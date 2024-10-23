package entity;

public class ChiTietHD_MonAn {
	private HoaDon hoaDon;
	private MonAn monAn;
	private int soLuong;
	private double thanhTien;

	public ChiTietHD_MonAn(HoaDon hoaDon, MonAn monAn, int soLuong, double thanhTien) {
		super();
		this.hoaDon = hoaDon;
		this.monAn = monAn;
		this.soLuong = soLuong;
		this.thanhTien = thanhTien;
	}
	public ChiTietHD_MonAn(String tenMonAn, double gia, int soLuong, double vat, double thanhTien) {
		this.monAn = new MonAn(); // Khởi tạo đối tượng MonAn
		this.monAn.setTenMonAn(tenMonAn);
		this.monAn.setGia(gia);
		this.monAn.setVAT(vat);
		this.soLuong = soLuong;
		this.thanhTien = thanhTien;
	}

	public ChiTietHD_MonAn() {
		super();
	}

    public HoaDon getHoaDon() {
		return hoaDon;
	}

	public void setHoaDon(HoaDon hoaDon) {
		this.hoaDon = hoaDon;
	}

	public MonAn getMonAn() {
		return monAn;
	}

	public void setMonAn(MonAn monAn) {
		this.monAn = monAn;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public double getThanhTien() {
		return thanhTien;
	}

	public void setThanhTien(double thanhTien) {
		this.thanhTien = thanhTien;
	}
	public double getVAT() {
		return this.monAn.getVAT();
	}
	public double getGia() {
		return this.monAn.getGia();
	}
	public String getTenMonAn() {
		return monAn.getTenMonAn();
	}

	@Override
	public String toString() {
		return "ChiTietHD_MonAn [hoaDon=" + hoaDon + ", monAn=" + monAn + ", soLuong=" + soLuong + ", thanhTien="
				+ thanhTien + "]";
	}

}
