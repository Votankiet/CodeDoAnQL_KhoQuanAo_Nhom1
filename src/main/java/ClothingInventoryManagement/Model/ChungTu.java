package ClothingInventoryManagement.Model;

public class ChungTu {
    public int soLuong;
	public int donGia;
	public String maHang;
	public String maNCC;
	public String maXX;
	
	public ChungTu(int soLuong, int donGia, String maHang, String maNCC, String maXX) {
		this.soLuong = soLuong;
		this.donGia = donGia;
		this.maHang = maHang;
		this.maNCC = maNCC;
		this.maXX = maXX;
	}
	public ChungTu() {
		
	}
}
