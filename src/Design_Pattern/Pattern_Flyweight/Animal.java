package Design_Pattern.Pattern_Flyweight;

/**
 * Created by ducdh1210 on 10/10/14.
 */
// By making this class cloneable you are telling Java
// that it is ok to copy instances of this class
// These instance copies have different results when
// System.identityHashCode(System.identityHashCode(bike))
// is called
public interface Animal extends Cloneable{
    public Animal makeCopy();
}


