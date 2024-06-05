
package data;

public class Cat extends Pet{
    private String ribbon;
    //constructor

    public Cat(String ID, String owner, String color, 
                        double weight, String ribbon) {
        super(ID, owner, color, weight);
        this.ribbon = ribbon;
    }
    //getter

    public String getRibbon() {
        return ribbon;
    }

    //setter

    public void setRibbon(String ribbon) {
        this.ribbon = ribbon;
    }

    //showInfor
    @Override
    public void showInfor() {
        String str = String.format("%4s|%-12s|%-12s|%6.2f|%s ",
                ID, owner, color, weight, ribbon);
        System.out.println(str);
    }
    @Override
    public String toString() {
        String str = String.format("%4s|%-12s|%-12s|%6.2f|%s ", 
                        ID, owner, color, weight, ribbon);
        return str;//"Ném" chuỗi đẹp ra bên ngoài cho người khác dùng
    }
    
}
