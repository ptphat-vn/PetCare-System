
package data;

public class Dog extends Pet{
    private String necklace;
    //constructor

    public Dog(String ID, String owner, String color, 
                    double weight, String necklace) {
        super(ID, owner, color, weight);
        this.necklace = necklace;
    }
    //getter

    public String getNecklace() {
        return necklace;
    }
    
    //setter

    public void setNecklace(String necklace) {
        this.necklace = necklace;
    }
    
    
    //showInfor

    @Override
    public void showInfor() {//Tạo ra chuỗi đẹp và "In" ra màng hình
        String str = String.format("%4s|%-12s|%-12s|%6.2f|%s ", 
                        ID, owner, color, weight, necklace);// tạo chuỗi đẹp
        System.out.println(str);//in ra chuỗi đẹp, và sài được
    }
    //toString tạo ra chuỗi đẹp và không dùng để in

    @Override
    public String toString() {
        String str = String.format("%4s|%-12s|%-12s|%6.2f|%s ", 
                        ID, owner, color, weight, necklace);
        return str;//"Ném" chuỗi đẹp ra bên ngoài cho người khác dùng
    }
    
}
