package baitap_quanlysanpham;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class ThongTinSanPham implements Serializable {
    private String maSp;
    private String nameSp;
    private String hangSx;
    private double giaSp;
    private String themMoTa;

    ThongTinSanPham() {

    }

    ThongTinSanPham(String maSp, String nameSp, String hangSx, double giaSp, String themMoTa) {
        this.maSp = maSp;
        this.nameSp = nameSp;
        this.hangSx = hangSx;
        this.giaSp = giaSp;
        this.themMoTa = themMoTa;
    }

    private String getMaSp() {
        return maSp;
    }

    private String setMaSp(String maSp) {
        this.maSp = maSp;
        return maSp;
    }

    private String getNameSp() {
        return nameSp;
    }

    private String setNameSp(String nameSp) {
        this.nameSp = nameSp;
        return nameSp;
    }

    private String getHangSx() {
        return hangSx;
    }

    private String setHangSx(String hangSx) {
        this.hangSx = hangSx;
        return hangSx;
    }

    private double getGiaSp() {
        return giaSp;
    }

    private double setGiaSp(double giaSp) {
        this.giaSp = giaSp;
        return giaSp;
    }

    private String getThemMoTa() {
        return themMoTa;
    }

    private String setThemMoTa(String themMoTa) {
        this.themMoTa = themMoTa;
        return themMoTa;
    }

    String fileName = "infomation.data";
    List<ThongTinSanPham> infos = new ArrayList<>();

    void hienThiTT() {

        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("---------------------MENU FOR YOU-------------------------");
            System.out.println("1.  Thêm sản phẩm vào giỏ hàng.");
            System.out.println("2.  Tìm kiếm thông tin sản phẩm.");
            System.out.println("3.  Hiển thị toàn bộ thông tin sản phẩm trong giỏ hàng.");
            System.out.println("0.  Exit programing.");
            System.out.println("----------------------------------------------------------");
            System.out.print("Nhập lựa chọn: ");
            int choise = Integer.parseInt(sc.nextLine());
            switch (choise) {
                case 1:
                    System.out.println("1. Thêm sản phẩm vào giỏ hàng.");
                    System.out.print("Nhập mã sản phẩm: ");
                    String ma = setMaSp(sc.nextLine());
                    System.out.print("Tên sản phẩm: ");
                    String ten = setNameSp(sc.nextLine());
                    System.out.print("Hãng của sản phẩm: ");
                    String hang = setHangSx(sc.nextLine());
                    System.out.print("Giá của sản phẩm: ");
                    double gia = setGiaSp(Double.parseDouble(sc.nextLine()));
                    System.out.print("Thêm mô tả cho sản phẩm: ");
                    String mota = setThemMoTa(sc.nextLine());
                    System.out.println("Thêm sản phẩm vào giỏ hàng.");
                    infos.add(new ThongTinSanPham(ma, ten, hang, gia, mota));
                    break;
                case 2:
                    System.out.println("2.  Tìm kiếm thông tin sản phẩm.");
                    System.out.print("Nhập thông tin bạn muốn tìm kiếm: ");
                    String tenmay = sc.nextLine();
                    for (int i = 0; i < infos.size(); i++) {
                        if (tenmay.equalsIgnoreCase(infos.get(i).getNameSp())) {
                            System.out.println("Thông tin sản phẩm bạn muốn tìm kiếm là: ");
                            System.out.println("-------------------------------------------------------------");
                            System.out.println("Mã sản phẩm là: " + infos.get(i).getMaSp());
                            System.out.println("Tên sản phẩm là: " + infos.get(i).getNameSp());
                            System.out.println("Hãng sản xuất sản phẩm là: " + infos.get(i).getHangSx());
                            System.out.println("Giá của sản phẩm là: " + infos.get(i).getGiaSp());
                            System.out.println("Mô tả thêm: " + infos.get(i).getThemMoTa());
                            System.out.println("-------------------------------------------------------------");
                        } else {
                            System.out.println("Thông tin bạn tìm kiếm không tồn tại trong giỏ hàng. vui lòng nhập lại.");
                        }
                    }
                    break;
                case 3:
                    System.out.println("3.  Hiển thị toàn bộ thông tin sản phẩm trong giỏ hàng.");
                    test();
                case 0:
                    System.out.println("0.  Exit programing.");
                    System.exit(0);
                    break;
            }
        }
    }

    private void test() {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(fileName);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(infos);
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileInputStream fileInputStream = new FileInputStream(fileName);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            infos = (List<ThongTinSanPham>) objectInputStream.readObject();
            System.out.println("------------------------------------------------------------------");
            for (ThongTinSanPham info : infos) {
                System.out.println("Mã sản phẩm là: " + info.getMaSp());
                System.out.println("Tên sản phẩm là: " + info.getNameSp());
                System.out.println("Hãng sản xuất sản phẩm là: " + info.getHangSx());
                System.out.println("Giá của sản phẩm là: " + info.getGiaSp());
                System.out.println("Mô tả thêm: " + info.getThemMoTa());
                System.out.println("------------------------------------------------------------------");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
