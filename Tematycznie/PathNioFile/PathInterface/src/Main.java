import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.nio.file.attribute.FileTime;
import java.nio.file.attribute.PosixFileAttributeView;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.UserPrincipal;
import java.util.Set;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) throws IOException {

        //---------------------------PODSTAWOWE_OPERACJE--------------------------------------------------

        //W starszej wersji Javy niż 11 Paths.get zamiast Path.of
        Path path = Path.of("C:/Users/przem/GitHub/Java_learning/Tematycznie/PathNioFile/file.txt");
        System.out.println(path);

        //Czy plik istnieje?
        boolean exists = Files.exists(path);
        System.out.println("Does the file exist? " + exists);

        //Kiedy był modyfikowany?
        FileTime lastModifiedTime = Files.getLastModifiedTime(path);
        System.out.println("Last modified time: " + lastModifiedTime);

        //Porównywanie dwóch plików. Porównuje rozmiar i bytecode. Zwraca index pierwszej różnicy
        //lub '-1L' jak pliki są identyczne
        long mismatchIndex = Files.mismatch(path, Paths.get("C:/Users/przem/GitHub/Java_learning/Tematycznie/PathNioFile/second.txt"));
        System.out.println("First mismatch at index: " + mismatchIndex);

        //Kto jest właścicielem pliku
        UserPrincipal owner = Files.getOwner(path);
        System.out.println("Owner: " + owner);

        //tworzenie plików tymczasowych - temp files
        //możemy określić prefix i suffix, prefix będzie przedrostkiem naszego pliku a suffix przyrostkiem
        //domyślnie suffix to '.tmp'. Możemy również określić lokalizację plików tymczasowych,
        //inaczej zostaną utworzone w lokalizacji domyślnej. Pliki te same się nie usuwają, trzeba o to zadbać
        /*Path tmpDirectory = Files.createTempDirectory("prefix");
        System.out.println("tmpDirectory = " + tmpDirectory);
        Path tempFile1 = Files.createTempFile("somePrefixForTmpFile", ".jpg");
        System.out.println("tempFile1 = " + tempFile1);
        Path tempFile2 = Files.createTempFile("somePrefixForTmpFile", ".jpg");
        System.out.println("tempFile2 = " + tempFile2);*/

        //Podobnie tworzymy zwykłe pliki i ścieżki
        Path newDirectory = Files.createDirectories(path.getParent().resolve("some/new/dir"));
        System.out.println("newDirectory = " + newDirectory);

        String name = "emptyFile.txt";
        try {
            Path newFile = Files.createFile(newDirectory.resolve(name));
        } catch (FileAlreadyExistsException e) {
            System.out.println("File " + name + " already exists");
        }


        //Jak uzyskać Posix permissions?
        /*try {
            Set<PosixFilePermission> permissions = Files.getPosixFilePermissions(path);
            System.out.println(permissions);
        } catch (UnsupportedOperationException e) {
            System.err.println("You are not running on a posix file system");
        }*/

        // ------------------------WRITING_AND_READING_FILES-------------------------------
        Files.writeString(path, "This is my text to write in a file");

        //zapisywanie danych jako bytcode. Dla Java < 11 używamy '.writeString'
        Path second = Path.of("C:/Users/przem/GitHub/Java_learning/Tematycznie/PathNioFile/second.txt");
        Files.write(second, "This is some text \n and another line".getBytes(StandardCharsets.ISO_8859_1));

        //Reading
        String s = Files.readString(second);
        System.out.println("Second: " + s);

        //Reading bits?
        byte[] b = Files.readAllBytes(second);
        System.out.println("Bytes: " + b);
        s = new String(b, StandardCharsets.ISO_8859_1);
        System.out.println("String from bytes: " + s);
        //albo razem: String s = new String(Files.readAllBytes(second), StandardCharsets.ISO_8859_1);

        //-----------------------BUFFERED_READER_AND_BUFFERED_WRITER----------------------------
        BufferedReader reader = Files.newBufferedReader(Paths.get("C:/Users/przem/GitHub/Java_learning/Tematycznie/PathNioFile/second.txt"));
        String readText = reader.lines().collect(Collectors.joining(System.lineSeparator()));

        System.out.println(readText);
        reader.close();

        //----------------------MOVING_DELETING_LISTING-----------------------------------------
        try {
            Files.move(second, Path.of("C:/Users/przem/GitHub/Java_learning/Tematycznie/PathNioFile/some/second.txt"));
            //you have to give full directory with file at the end
        } catch (FileAlreadyExistsException e) {
            System.out.println("File already exists in this place");
        }
        //reverse moving
        try {
            Files.move(Path.of("C:/Users/przem/GitHub/Java_learning/Tematycznie/PathNioFile/some/second.txt"), second);
            //you have to give full directory with file at the end
        } catch (FileAlreadyExistsException e) {
            System.out.println("File already exists in this place");
        }

        //po ścieżce docelowej można dodać opcję po przecinku:
        //StandardCopyOption.REPLACE_EXISTING - if file already exists will be overwriten
        //StandardCopyOption.ATOMIC_MOVE

        /*
        This deletes only empty directories:

        try {
            Files.delete(tmpDir);
        } catch (DirectoryNotEmptyException e) {
            e.printStackTrace();
        }

        Aby usunąć pełne, trzeba zajrzeć do każdego z folderów i usuwać 'od środka':

        try (Stream<Path> walk = Files.walk(tmpDir)) {
            walk.sorted(Comparator.reverseOrder()).forEach(path -> {
            try {
                Files.delete(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
}
         */

        //Listing files only in the same directory:
        try (var files = Files.list(Path.of("C:/Users/przem/GitHub/Java_learning/Tematycznie/PathNioFile/"))) {
            files.forEach(System.out::println);
        }
        System.out.println();

        try (var files = Files.newDirectoryStream(Path.of("C:/Users/przem/GitHub/Java_learning/Tematycznie/PathNioFile"),
                "*.txt")) {
            files.forEach(System.out::println);
        }

        //Listing all files recursively
        try (var files = Files.walk(Path.of("C:/Users/przem/GitHub/Java_learning/Tematycznie/PathNioFile/"))) {
            files.forEach(System.out::println);
        }
        //do przefiltrowania można użyć streama, ale musi być też zamknięty w bloku try-catch


        //=====================================ABSOLUTE_RELATIVE_CANONICAL_FILES---------------
        //relative path - w odniesieniu do obecnej lokalizacji. Zaczyna się o kropki
        // path.isAbsolute(); return false; tak będzie w tym przypadku
        //absolute path - Zaczynamy od głównego dysku. Możemy przekonwertować ścieżkę relative do absolute:
        //path2 = path.toAbsolutePath();
        //path2.isAbsolute(); return true

        //path.normalize().toAbsolutePath() - pozbywa się wszystkich kropek

        //możemy zrelatywizować ścieżkę z absolutnej:
        Path relativePath = Paths.get("C:/Users/przem/GitHub").relativize(path);
        System.out.println(relativePath);


    }
}