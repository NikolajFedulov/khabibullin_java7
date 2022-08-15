package listing_02_07;

public class Nested {
    // The "outerClassPrivateVariable" variable is declared static so that it can be accessed from the static classes
    // InnerStaticClassA and InnerStaticClassAB.
    // The "outerClassPrivateVariable" variable is meant to demonstrate access to a field of an outer class
    static private int outerClassPrivateVariable;
    String s = "Member of Nested";

    // We nest a static class. The full name of this class is Nested.InnerStaticClassA
    static class InnerStaticClassA {
        private int innerClassAVariable = outerClassPrivateVariable;
        String s = "Member of InnerStaticClassA";

        // In the nested class InnerStaticClassA we nest one more static class.
        // The full class name is Nested.InnerStaticClassA.InnerStaticClassAB
        static class InnerStaticClassAB {
            private int innerClassABVariable = outerClassPrivateVariable;
            String s = "Member of InnerStaticClassAB";
        }
    }

    // We nest a non-static class in the Nested class. The full name of this class is Nested.InnerClassB
    class InnerClassB {
        private int innerClassBVariable = outerClassPrivateVariable;
        String s = "Member of InnerClassB";

        // Add another class to class InnerClassB. The full class name is Nested.InnerClassB.InnerClassBC
        class InnerClassBC {
            private int innerClassBCVariable = outerClassPrivateVariable;
            String s = "Member of InnerClassBC";
        }

        void someMethod(final int i){
            // Without the final modifier, the variables i and j cannot be used in the local class LocalClassD.
            final int j = 99;

            // The local class LocalClassD is only known inside someMethod().
            class LocalClassD {
                private int localClassDVariable = outerClassPrivateVariable;
                String s = "Member of LocalClassD";

                void localClassDMethod(){
                    // Notice how the variables with the same name "s" are distinguished.
                    // "s" is equivalent to "this.s".
                    System.out.println(s + (i+j));
                    System.out.println(InnerClassB.this.s);
                    System.out.println(Nested.this.s);
//                    System.out.println(InnerStaticClassAB.this.s);    // No access.
//                    System.out.println(InnerStaticClassA.this.s);     // No access.
                }
            }

            // The object is defined right there, in the someMethod() method.
            // The object is only known in the someMethod() method.
            LocalClassD localClassD = new LocalClassD();
            localClassD.localClassDMethod();
        }
    }

    void methodOfClassNested(){
        // An object of an unnamed class is created, the constructor of its superclass is specified.
        new Object(){
            private int unnamedClassVariable = outerClassPrivateVariable;
            void unnamedClassMethod(){
                System.out.println("From unnamedClassMethod()");
            }
        }
        // The method of the newly created object is immediately executed.
        .unnamedClassMethod();
    }
}
