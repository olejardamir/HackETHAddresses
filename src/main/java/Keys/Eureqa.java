package Keys;

import org.apache.commons.math3.analysis.function.Acosh;
import org.apache.commons.math3.analysis.function.Asinh;
import org.apache.commons.math3.special.Erf;

public class Eureqa {
    //c = tanh(-24*not(gauss(x2))*xor(1 + z7/y7, z7))

    public static double  tanh(double x){
        return Math.tanh(x);
    }

    //Returns 0 if x is greater than 0, 1 otherwise
    public static double not (double x){
        return x > 0 ? 0 : 1;
    }

    //Returns 1 if (x <= 0 and y > 0) or (x > 0 and y <= 0), 0 otherwise
    public static double xor(double x, double y){
        return (x <= 0 && y > 0) || (x > 0 && y <= 0) ? 1 : 0;
    }

    //exp(-x^2)
    public static double gauss(double x){
        return Math.pow(exp(-x),2);
    }

    public static double exp(double x){
        return Math.exp(x);
    }

    public static double max(double x, double y){return Math.max(x,y);}

    public static double cos(double x){return Math.cos(x);}

    public static double atan2(double x, double y){return Math.atan2(x,y);}

    public static double asinh(double x){return new Asinh().value(x);}

    public static double sqrt(double x){return Math.sqrt(x);}

    public static double acosh(double x){return new Acosh().value(x);}

    public static double erf(double x){return  Erf.erf(x);
    }

    public static double sinh(double x){return Math.sinh(x);}
    public static double tan(double x){return Math.tan(x);}
    public static double log(double x){return Math.log(x);}
    public static double sin(double x){return Math.sin(x);}




}
