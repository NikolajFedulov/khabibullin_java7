package listing_02_07;

public class NestedClasses {
    public static void main(String[] args){
        Nested nest = new Nested();

        // There was a mistake in the original listing here.
        Nested.InnerStaticClassA theInnerStaticClassA = new Nested.InnerStaticClassA();
        Nested.InnerStaticClassA.InnerStaticClassAB theInnerStaticClassAB = new Nested.InnerStaticClassA.InnerStaticClassAB();

        // The new operator is qualified by only one name.
        Nested.InnerClassB theInnerClassB = nest.new InnerClassB();
        Nested.InnerClassB.InnerClassBC theInnerClassBC = theInnerClassB.new InnerClassBC();
        // Methods are called in the usual way.
        theInnerClassB.someMethod(999);
        nest.methodOfClassNested();
    }
}
