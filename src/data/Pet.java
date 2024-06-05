
package data;

public abstract class Pet {
    //props
    protected String ID;
    protected String owner;
    protected String color;
    protected double weight;
    //constructor

    public Pet(String ID, String owner, String color, double weight) {
        this.ID = ID;
        this.owner = owner;
        this.color = color;
        this.weight = weight;
    }
    
    //getter

    public String getID() {
        return ID;
    }

    public String getOwner() {
        return owner;
    }

    public String getColor() {
        return color;
    }

    public double getWeight() {
        return weight;
    }
    //setter

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
    
    
    //showInfor: tạo ra chuỗi đẹp, "In" chuỗi đẹp
    public abstract void showInfor();
}
