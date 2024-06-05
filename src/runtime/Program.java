
package runtime;

import data.PetManagerment;
import data.Cat;
import data.Dog;
import data.Pet;
import java.util.Scanner;
import ui.Menu;
import utils.Inputter;

public class Program {

    public static void main(String[] args) {
        //test code
        //tạo ra anh quản lí thay vì danh sách
        PetManagerment pm = new PetManagerment();
        //pm.initData();//pm nạp giá trị cho t
        String url = "C:\\Users\\Admin\\Desktop\\JAVA\\16-petCareSystem\\petListDoc.txt";
        pm.loadFromFile(url);
        
        Menu menu = new Menu("Pet Care System Menu");
        menu.addNewOption("Add new Dog");
        menu.addNewOption("Add new Cat");
        menu.addNewOption("Print Pet List");
        menu.addNewOption("Search Pet By Id");
        menu.addNewOption("Update Pet By Id");
        menu.addNewOption("Remove Pet By Id");
        menu.addNewOption("Sort Pet Order By Weight");
        menu.addNewOption("Save File And Quit");
        int choice;
        while(true){
            menu.print();
            choice = menu.getChoice();
            switch(choice){
                case 1: {
                    pm.addNewDog();
                    break;
                }
                case 2: {
                    pm.addNewCat();
                    break;
                }
                case 3: {
                    pm.showPetList();
                    break;
                }
                case 4: {
                    pm.searchPetById();
                    break;
                }
                case 5: {
                    pm.updatePetById();
                    break;
                }
                case 6: {
                    pm.removePetById();
                    break;
                }
                case 7: {
                    pm.sortPetListByWeight();
                    break;
                }
                case 8: {
                    pm.saveToFile(url);
                    System.out.println("See you again");
                    return;
                }
            }
        }
    }
}
/*
Viết 1 chương trình quản lý thú cưng (DOG | CAT)
    1. Thêm mới 1 con cún
    2. Thêm mới 1 con mèo
    3. in ra danh sách thú cưng
    4. tìm kiếm thú cưng theo tên
    5. update thú cưng theo id
    6. remove thú cưng theo id
    7. sắp xếp thú cưng theo trọng lượng
    8. save file and quit

    khi thêm mới id của pet k được trùng với id ở trong danh sách
    id của pet phải thỏa theo format "D001| C001"
    một con Pet có nhửng thuộc tính owner , color, weight
    
    Dog: necklace
    Cat: ribbon

    yêu cầu chung: nhập chuẩn | nhập bậy bạ là chữi
*/
//hàm test
//        pm.sortPetListByWeight();//pm ơi sắp xếp cho t đi
//        pm.showPetList();//pm in ra cho t
//        
//        //test hàm tìm vị trí
//        int pos = pm.searchPetIndexById("D001");//lưu vị trí tìm được
//        System.out.println(pos);//in vị trí tìm được
//        
//        //test hàm tìm con pet
//        Pet pet = pm.searchPetById("D003");//lưu vị trí tìm được
//        System.out.println(pet);//in ra con pet
//        
//        //test hàm 
//        //pm.searchPetById();
//        
//        //nhập 1 số nguyên chuẩn
//        int age = Inputter.getAnInteger("Nhập tuổi nhé: ",
//                                        "Mày không biết nhập tuổi hả?",1, 100);
//        int yob = Inputter.getAnInteger("Nhập năm sinh nhé: ",
//                                        "Mày biết nhập số nguyên không?");
//        System.out.println("Tuổi: " + age);
//        System.out.println("Năm sinh nè: " + yob);

/*
Quy tắc url:
    
*/