public class Main {
    public static void main(String[] args) {

// Serialization is a mechanism of converting the state of an object into a byte stream.
// Deserialization is the reverse process where the byte stream is used to recreate the actual Java object in memory.
// This mechanism is used to persist the object.The byte stream created is platform independent.
// Only the objects of those classes can be serialized which are implementing java.io.Serializable interface.
// Serializable is a marker interface. Child class doesn’t need to implement it. Static data members and transient
// data members are not saved via Serialization process. So, if you don’t want to save value of a non-static data
// member then make it transient. Constructor of object is never called when an object is deserialized.
//
// The Serialization runtime associates a version number with each Serializable class called a SerialVersionUID,
// which is used during Deserialization to verify that sender and receiver of a serialized object have loaded classes
// for that object which are compatible with respect to serialization. If not it will result in an InvalidClassException.
// It is strongly recommended that all serializable classes explicitly declare serialVersionUID value.
    }
}