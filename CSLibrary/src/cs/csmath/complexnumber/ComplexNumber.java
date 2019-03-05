/*Class Method: A kind of method, available in some object-oriented programming languages,
 that operates on the class as a whole,as opposed to an object method that operates on an
 object that is an instance of the class. (Taken from Google)

  ADT: “an abstract data type (ADT) is a mathematical model for data types, where a data
  type is defined by its behavior (semantics) from the point of view of a user of the data,
  specifically in terms of possible values, possible operations on data of this type, and
  the behavior of these operations.” (Taken from Google)
  */


package cs.csmath.complexnumber;

public class ComplexNumber {
    private double realPart;
    private double imagPart;

    public ComplexNumber(double realPart, double imagPart){
    this.realPart = realPart;
    this.imagPart = imagPart;
    }
    public double getRealPart() {
        return realPart;
    }

    public void setRealPart(double realPart) {
        this.realPart = realPart;
    }

    public double getImagPart() {
        return imagPart;
    }

    public void setImagPart(double imagPart) {
        this.imagPart = imagPart;
    }

    public ComplexNumber(ComplexNumber cn){
        this.realPart = cn.getRealPart();
        this.imagPart = cn.getImagPart();
    }

    public void add(ComplexNumber otherCN){
        double firstReal = this.getRealPart();
        double firstImag = this.getImagPart();
        double secondReal = otherCN.getRealPart();
        double secondImag = otherCN.getImagPart();
        double addedReal = firstReal + secondReal;
        double addedImag = firstImag + secondImag;
        this.setRealPart(addedReal);
        this.setImagPart(addedImag);
    }



    public static ComplexNumber add(ComplexNumber firstCN, ComplexNumber secondCN){
        ComplexNumber firstAdder = new ComplexNumber(firstCN);
        ComplexNumber secondAdder = new ComplexNumber(secondCN);
        firstAdder.add(secondAdder);
        return firstAdder;
    }

    public void sub(ComplexNumber otherCN){
        double firstReal = this.getRealPart();
        double firstImag = this.getImagPart();
        double secondReal = otherCN.getRealPart();
        double secondImag = otherCN.getImagPart();
        double subbedReal = firstReal - secondReal;
        double subbedImag = firstImag - secondImag;
        this.setRealPart(subbedReal);
        this.setImagPart(subbedImag);
    }

    public static ComplexNumber sub(ComplexNumber firstCN, ComplexNumber secondCN){
        ComplexNumber firstSubber = new ComplexNumber(firstCN);
        ComplexNumber secondSubber = new ComplexNumber(secondCN);
        firstSubber.add(secondSubber);
        return firstSubber;
    }

    public void mult(ComplexNumber otherCN){
        double firstReal = this.getRealPart();
        double firstImag = this.getImagPart();
        double secondReal = otherCN.getRealPart();
        double secondImag = otherCN.getImagPart();
        double multedReal = (firstReal*secondReal - firstImag*secondImag);
        double multedImag = (firstImag*secondReal + firstReal*secondImag);
        this.setRealPart(multedReal);
        this.setImagPart(multedImag);
    }

    public static ComplexNumber mult(ComplexNumber firstCN, ComplexNumber secondCN){
        ComplexNumber firstMulter = new ComplexNumber(firstCN);
        ComplexNumber secondMulter = new ComplexNumber(secondCN);
        firstMulter.mult(secondMulter);
        return firstMulter;
    }

    public void div(ComplexNumber otherCN) throws ArithmeticException {
        double firstReal = this.getRealPart();
        double firstImag = this.getImagPart();
        double secondReal = otherCN.getRealPart();
        double secondImag = otherCN.getImagPart();

        double denominator = (secondReal*secondReal) + (secondImag*secondImag);
        if (Math.abs(denominator)< 0.000001){
            throw new ArithmeticException();
        }
        double divedReal = (firstReal * secondReal + firstImag * secondImag) /
                (denominator);
        double divedImag = (firstImag * secondReal - firstReal * secondImag) /
                (denominator);

        this.setRealPart(divedReal);
        this.setImagPart(divedImag);
    }

    public static ComplexNumber div(ComplexNumber firstCN, ComplexNumber secondCN){
        ComplexNumber firstDiver = new ComplexNumber(firstCN);
        ComplexNumber secondDiver = new ComplexNumber(secondCN);
        firstDiver.div(secondDiver);
        return firstDiver;
    }

    public void conj(){
        double imagPart = getImagPart();
        imagPart = -(imagPart);
        this.setImagPart(imagPart);

    }

    public double abs(){
        double realPart = getRealPart();
        double imagPart = getImagPart();
        double sqrdRealPart = (realPart*realPart);
        double sqrdImagPart = (imagPart*imagPart);
        double absValue = Math.sqrt((sqrdRealPart + sqrdImagPart));
        return absValue;
    }

    public String toString() {
        String realPart = Double.toString(this.getRealPart());
        String imagPart = Double.toString(this.getImagPart());
        if (getImagPart() >= 0) {
            String complexString = realPart + " +" + imagPart + "i";
            return complexString;
        }
        else{
            String complexString = realPart + " " + imagPart + "i";
            return complexString;
        }
    }
    public static void main(String[] args){
        ComplexNumber cn1 = new ComplexNumber(3, 4);
        ComplexNumber cn2 = new ComplexNumber(5, 2);

        cn1.add(cn2);
        String test = cn1.toString();
        System.out.println(test);

        cn1.sub(cn2);
        test = cn1.toString();
        System.out.println(test);

        cn1.mult(cn2);
        test = cn1.toString();
        System.out.println(test);

        cn1.div(cn2);
        test = cn1.toString();
        System.out.println(test);

        cn1.conj();
        test = cn1.toString();
        System.out.println(test);

        double abs = cn1.abs();
        Double.toString(abs);
        System.out.println(abs);

    }
}


