package com.nadia.crackcode.gof.behavioral;

/**
 * In Strategy pattern, a class behavior or its algorithm can be changed at run time. This type of
 * design pattern comes under behavior pattern.
 * In Strategy pattern, we create objects which represent various strategies and a context object
 * whose behavior varies as per its strategy object. The strategy object changes the executing
 * algorithm of the context object.
 */
public class StrategyPattern {

    public static void main(String[] args) {
        Context context = new Context(new AddOperation());
        context.executeStrategy(45,64);

        context.setOperation(new SubstractOperation());
        context.executeStrategy(1,100);

        context.setOperation(new MultiplyOperation());
        context.executeStrategy(15,38);
    }

    private static class Context {

        Operation operation;

        private Context(Operation operation) {
            this.operation = operation;
        }

        private Operation getOperation() {
            return operation;
        }

        private void setOperation(Operation operation) {
            this.operation = operation;
        }

        public void executeStrategy(int i, int k) {
            System.out.println("EXEC STRATEGY: Operands: " + i + ", " + k
            + ". Result: " + operation.execute(i, k));
        }

    }

    private abstract static class Operation {
        public abstract int execute(int i, int k);
    }

    private static class AddOperation extends Operation {

        @Override
        public int execute(int i, int k) {
            return i + k;
        }

    }

    private static class SubstractOperation extends Operation {

        @Override
        public int execute(int i, int k) {
            return i - k;
        }

    }

    private static class MultiplyOperation extends Operation {

        @Override
        public int execute(int i, int k) {
            return i * k;
        }

    }
}
