
package data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.StringTokenizer;
import utils.Inputter;
import static utils.Inputter.sc;

/*
PetManagerment: 1 cái khuôn dùng để đúc ra anh quản lí danh sách thú cưng
PetManagerment phải có: danh sách thú cưng petList
PetManagerment phải cos 1 đống method giúp xử lí petList
trong đống đó chắc chắn phải có: hàm thêm, xóa, sửa, tìm, sắp xếp
    
    1. in ra danh sách thú cưng
    2. sắp xếp thú cưng theo trọng lượng
    3. tìm kiếm thú cưng theo tên
    4. update thú cưng theo id
    4. remove thú cưng theo id
    5. Thêm mới 1 con cún
    5. Thêm mới 1 con mèo
    6. save file and quit
*/
public class PetManagerment {
    //petManagerment: anh quản lí danh sách thú cưng
    //ảnh sở hữu danh sách thú cưng
    ArrayList<Pet> petList = new ArrayList<>();
    
    //ảnh còn có thêm 1 đống method xử lí petList
    //initData(): hàm nhét vào danh sách 2 chó 2 mèo giúp mình test code
    public void initData(){
        petList.add(new Dog("D001", "Tuấn", "red", 6.5, "I < U"));
        petList.add(new Dog("D002", "Toàn", "yellow", 2.6, "Yellow"));
        petList.add(new Cat("C001", "Tùng", "Nâu", 4.2, "Mỹ Diệu"));
        petList.add(new Cat("C002", "Thông", "Tím", 5.2, "Thông Tìm"));
        
    }
    
    //showPetList(): In ra các con vật trong danh sách
    public void showPetList(){
        if(petList.isEmpty()){//isEmpty(): ktra xem rỗng hay k
            System.out.println("Nothing to print");
            return;// ngừng luôn, không chạy xuống nữa
        }
        System.out.println("______PETLIST______");
        for (Pet item : petList) {
            item.showInfor();
        }
    }
    
    //sortPetListByWeight(): sắp xếp danh sách thú cưng theo cân nặng
    public void sortPetListByWeight() {
        //1. tạo anh trọng tài 'orderByWeight'
        Comparator orderByWeight = new Comparator<Pet>() {
            @Override
            public int compare(Pet t1, Pet t2) {
                return (int)(t1.getWeight()- t2.getWeight());
                //nếu t1 - t2 ra số thực thì ép kiểu (int) ra 1; 0; -1   
            }
        };//nếu như cân nặng thằng t1 mà lớn hơn cân nặng của t2 thì return 1
        //còn không thì return -1;
        
        //2. cài anh trọng tài vào danh sách
        Collections.sort(petList, orderByWeight);
        //sắp xếp danh sách thú cưng dựa vào cân nặng
        
        //Không được in
    }
    
    //3.Tìm kiếm
    //- nhận vào id, trả ra vị trí
    public int searchPetIndexById(String keyID){
        for (int i = 0; i <= petList.size() - 1; i++) {
            if(petList.get(i).getID().equals(keyID)){
            //mã của thằng ở vị trí thứ i trong danh sách có giống với mã đang
            //cần tìm hay không
                return i;
            }
        }
        return -1;
    }
    
    //- nhận vào id, trả ra con pet
    public Pet searchPetById(String keyID){
            int pos = searchPetIndexById(keyID);//tìm vị trí trước nè
            return pos == -1 ? null : petList.get(pos);
            //vô danh sách lấy con pet ở vị tri tìm được
    }
    
    //- xin id, không trả ra, thông báo thôi
    public void searchPetById() {
        //xin keyId từ người dùng
        String keyId = Inputter.getString("Input petId you wanna find: ",
                                        "That field is required!!");
        //tìm kiếm dựa trên keyId tìm con pet
        Pet pet = searchPetById(keyId);
        //thông báo kết quả
        if(pet == null){
            System.out.println("The pet not exist");
        }else{
            System.out.println("The pet information");
            pet.showInfor();
        }
    } 
    
    //hàm removePetById(): hàm xin id tìm pet và xóa
    public void removePetById() {
        //xin keyId từ người dùng
        String keyId = Inputter.getString("Input petId you wanna remove: ",
                                        "That field is required!!");
        //tìm kiếm dựa trên keyId tìm con pet
        Pet pet = searchPetById(keyId);
        //thông báo kết quả
        if(pet == null){
            System.out.println("The pet not exist");
        }else{
            System.out.println("The pet information");
            pet.showInfor();
            petList.remove(pet);
            System.out.println("Removing is successful");
        }
    } 
    
    //hàm updatePetById()
    public void updatePetById() {
        //xin keyId từ người dùng
        String keyId = Inputter.getString("Input petId you wanna update: ",
                                        "That field is required!!");
        //tìm kiếm dựa trên keyId tìm con pet
        Pet pet = searchPetById(keyId);
        //thông báo kết quả
        if(pet == null){//nếu k có thì nói k có
            System.out.println("The pet not exist");
        }else{
            System.out.println("The pet information before updating");
            pet.showInfor();
            //cần cập nhật owner, color, weight
            System.out.println("Updating...");
            String newOwner = Inputter.getString("Input owner: ", 
                                                    "That field is required");
            String newColor = Inputter.getString("Input color: ", 
                                                    "That field is required");
            double newWeight = Inputter.getADouble("Input weight: ",
                                                "Weight must between 1 and 100",
                                                1, 100);
            pet.setOwner(newOwner);
            pet.setColor(newColor);
            pet.setWeight(newWeight);
            //dog thì có necklace, mèo thì có ribbon
            if(pet instanceof Dog){//thêm vào đặt tính của con vật
                String newNecklace = Inputter.getString("Input Necklace: ",
                                                    "That field is required");
                //pet.setNecklace không viết được
                ((Dog)pet).setNecklace(newNecklace);
            }else{
                String newRibbon = Inputter.getString("Input Ribbon: ",
                                                    "That field is required");
                ((Cat)pet).setRibbon(newRibbon);
            }
            System.out.println("Updating is sucessful");
        }
    }
    
    //Method addNewDog(): thêm 1 con chó
    public void addNewDog(){
        //thu thập thông tin để đúc con chó
        boolean isDup;
        String id;
        do{
            isDup = false;//ban đầu sẽ tin là không trùng
            id = Inputter.getString("Input your Dog's id: ",
                                    "Your id isn't matched DXXX!!!", 
                                    "[dD]\\d{3}").toUpperCase();
            //nhập đến đây là mã chuẩn, nhưng chưa biết có người sd hay chưa
            Pet pet = searchPetById(id);
            if(pet != null){
                isDup = true;
                System.out.println("Id has been used");
            }
            
        }while(isDup);
        //Nhập thông tin còn lại
        String owner = Inputter.getString("Input owner: ", 
                                                    "That field is required");
        String color = Inputter.getString("Input color: ", 
                                                "That field is required");
        double weight = Inputter.getADouble("Input weight: ",
                                            "Weight must between 1 and 100",
                                            1, 100);
        String necklace = Inputter.getString("Input Necklace: ",
                                                    "That field is required");
        
        //tạo
        Dog nDog = new Dog(id, owner, color, weight, necklace);
        petList.add(nDog);
        System.out.println("Adding is successful");
        
    }
    //Method addNewCat(): hàm thêm 1 con mèo
    
    public void addNewCat(){
        //thu thập thông tin để đúc con mèo
        boolean isDup;
        String id;
        do{
            isDup = false;//ban đầu sẽ tin là không trùng
            id = Inputter.getString("Input your Cat's id: ",
                                    "Your id isn't matched CXXX!!!", 
                                    "[cC]\\d{3}").toUpperCase();
            //nhập đến đây là mã chuẩn, nhưng chưa biết có người sd hay chưa
            Pet pet = searchPetById(id);
            if(pet != null){
                isDup = true;
                System.out.println("Id has been used");
            }
            
        }while(isDup);
        //Nhập thông tin còn lại
        String owner = Inputter.getString("Input owner: ", 
                                                    "That field is required");
        String color = Inputter.getString("Input color: ", 
                                                "That field is required");
        double weight = Inputter.getADouble("Input weight: ",
                                            "Weight must between 1 and 100",
                                            1, 100);
        String ribbon = Inputter.getString("Input Ribbon: ",
                                                    "That field is required");
        
        //tạo
        Cat nCat = new Cat(id, owner, color, weight, ribbon);
        petList.add(nCat);
        System.out.println("Adding is successful");
        
    }
    
    //method đọc file
    public boolean loadFromFile(String url){
        File f = new File(url);//biến url thành object File
        try {
            //xử lí file, mỗi lần đọc thì đọc được 1 dòng.
            BufferedReader reader = new BufferedReader(new FileReader(f));
            String line = reader.readLine();//đọc dòng đầu tiên và lưu
            while(line != null){//nếu có dòng thì mình xử lí, hết thì thoi
                //xử lí từng dòng
                StringTokenizer st = new StringTokenizer(line, "|");
                String id = st.nextToken().trim();
                String owner = st.nextToken().trim();
                String color = st.nextToken().trim();
                double weight = Double.parseDouble(st.nextToken().trim());
                String special= st.nextToken().trim();
                //phân tích id thu được, từ đó chọn khuôn phù hợp
                Pet pet;//tạo ra con pet rỗng
                if(id.matches("[dD]\\d{3}")){
                    pet = new Dog(id, owner, color, weight, special);
                }else{
                    pet = new Cat(id, owner, color, weight, special);
                }
                petList.add(pet);
                line = reader.readLine();//đọc dòng tiếp theo
                //KHÔNG ĐƯỢC THIẾU DÒNG NÀY
            }
            
            //nếu xử lý xong thì 
            return true;
        } catch (Exception e) {
            System.out.println("File lỗi" + e);
            return false;
        }
    }
    //Method lưu file
    public boolean saveToFile(String url){
        File f = new File(url);
        try {
            //xử lí file
            OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(f));
            //viết từng dòng
            for (Pet pet : petList) {
                writer.write(pet.toString());
                writer.write("\n");  
            }
            writer.flush();//save trước khi đóng file
            return true;
        } catch (Exception e) {
            System.out.println("Lưu file thất bại" + e);
            return false;
        }
    }
    
}
//SOLID: mỗi 1 hàm chỉ nên làm đúng nhiệm vụ này thôi
//Single Over
