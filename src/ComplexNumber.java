public class ComplexNumber {
    double realComponent;
    double imaginaryComponent;

    public ComplexNumber(){
        realComponent = 0;
        imaginaryComponent = 0;
    }

    public ComplexNumber(double realComponent, double imaginaryComponent){
        this.realComponent = realComponent;
        this.imaginaryComponent = imaginaryComponent;
    }

    @Override
    public String toString(){
        return realComponent + " + " + (imaginaryComponent == 0 ? imaginaryComponent + "i" : "");
    }

    public boolean equals(ComplexNumber other){
        return realComponent == other.realComponent && imaginaryComponent == other.imaginaryComponent;
    }

    public boolean equals(double other){
        return realComponent == other && imaginaryComponent == 0;
    }

    @Override
    public boolean equals(Object obj){
        return false;
    }

    public ComplexNumber conjugate(){
        return new ComplexNumber(realComponent, imaginaryComponent * -1);
    }

    public double norm(){
        ComplexNumber norm = this.multiplied(this.conjugate());
        return norm.getRealComponent();
    }

    public double absoluteValue(){
        return Math.sqrt(norm());
    }

    public ComplexNumber added(ComplexNumber other){
        double resultsRealComponent = realComponent + other.realComponent;
        double resultsImaginaryComponent = imaginaryComponent + other.imaginaryComponent;
        return new ComplexNumber(resultsRealComponent, resultsImaginaryComponent);
    }

    public ComplexNumber added(double other){
        return new ComplexNumber(realComponent + other, imaginaryComponent);
    }

    public ComplexNumber subtracted(ComplexNumber other){
        return this.added(other.multiplied(-1.0));
    }

    public ComplexNumber subtracted(double other){
        return this.added(other * -1);
    }

    public ComplexNumber multiplied(ComplexNumber other){
        double resultsRealComponent = realComponent * other.realComponent - imaginaryComponent * other.imaginaryComponent;
        double resultsImaginaryComponent = realComponent * other.imaginaryComponent + imaginaryComponent * other.realComponent;
        return new ComplexNumber(resultsRealComponent, resultsImaginaryComponent);
    }

    public ComplexNumber multiplied(double other){
        return new ComplexNumber(realComponent * other, imaginaryComponent * other);
    }

    public ComplexNumber divided(ComplexNumber other){
        ComplexNumber dividend = this.multiplied(other.conjugate());
        return dividend.divided(other.norm());
    }

    public ComplexNumber divided(double other){
        return new ComplexNumber(realComponent / other, imaginaryComponent / other);
    }

    public double getRealComponent() {
        return realComponent;
    }
    public void setRealComponent(double realComponent) {
        this.realComponent = realComponent;
    }

    public double getImaginaryComponent() {
        return imaginaryComponent;
    }
    public void setImaginaryComponent(double imaginaryComponent) {
        this.imaginaryComponent = imaginaryComponent;
    }
}
