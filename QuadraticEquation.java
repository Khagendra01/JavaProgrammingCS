public class QuadraticEquation {
    private double a, b, c;

    public QuadraticEquation(double a, double b, double c)
                                throws IllegalArgumentException {
        if (a == 0.0) {
            throw new IllegalArgumentException(
                    "Coefficient 'a' cannot be 0 in a quadratic equation.");
        }
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    public double discriminant() {
        return b * b - 4 * a * c;
    }

    public double root1() {
        double discriminant = discriminant();
        if (discriminant < 0) {
            return 0.0;
        }
        double root = (-b + Math.sqrt(discriminant)) / (2 * a);
        return root == -0.0 ? 0.0 : root;
    }

    public double root2() {
        double discriminant = discriminant();
        if (discriminant < 0) {
            return 0.0;
        }
        double root = (-b - Math.sqrt(discriminant)) / (2 * a);
        return root == -0.0 ? 0.0 : root;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(getA());
        if(getB()>0) {
        builder.append("x^2+");
        builder.append(getB());
        }else {
        	builder.append("x^2");
            builder.append(getB());
        }
        if(getC()>0) {
        builder.append("x+");
        builder.append(getC());
        }else {
        	builder.append("x");
            builder.append(getC());
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        if (args.length != 3) {
            System.err.println("Usage: java QuadraticEquation <a> <b> <c>");
            System.exit(1);
        }
        double a = 0.0, b = 0.0, c = 0.0;
        try {
            a = Double.parseDouble(args[0]);
        } catch (NumberFormatException nfe) {
            System.err.println("Error: Invalid value '" + args[0] + "' for a.");
            System.exit(1);
        }
        try {
            b = Double.parseDouble(args[1]);
        } catch (NumberFormatException nfe) {
            System.err.println("Error: Invalid value '" + args[1] + "' for b.");
            System.exit(1);
        }
        try {
            c = Double.parseDouble(args[2]);
        } catch (NumberFormatException nfe) {
            System.err.println("Error: Invalid value '" + args[2] + "' for c.");
            System.exit(1);
        }
        QuadraticEquation qe = null;
        try {
            qe = new QuadraticEquation(a, b, c);
        } catch (IllegalArgumentException iae) {
            System.err.println("Error: " + iae.getMessage());
            System.exit(1);
        }
        System.out.println(qe);
        double discriminant = qe.discriminant();
        System.out.printf("Discriminant: %.6f", discriminant);
        System.out.println();
        if (discriminant < 0) {
            System.out.println("The equation has no real roots.");
        } else {
            System.out.printf("Root 1: %.6f", qe.root1());
            System.out.println();
            System.out.printf("Root 2: %.6f", qe.root2());
            System.out.println();
        }
    }
}
