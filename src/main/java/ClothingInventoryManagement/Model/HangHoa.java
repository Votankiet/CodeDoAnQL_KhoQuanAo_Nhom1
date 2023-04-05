package ClothingInventoryManagement.Model;

public class HangHoa {
    public String maHang;
    public String tenHang;
    public String mauSac;
    public String kichCo;
    public int donGia;
    public String xuatXu;

    public HangHoa(String maHang, String tenHang, String mauSac, String kichCo, int donGia, String xuatXu) {
        this.maHang = maHang;
        this.tenHang = tenHang;
        this.mauSac = mauSac;
        this.kichCo = kichCo;
        this.donGia = donGia;
        this.xuatXu = xuatXu;
    }
    public HangHoa() {

    }
}
