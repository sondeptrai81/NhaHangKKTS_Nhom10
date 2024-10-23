package entity;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

public class HoaDon {
	private String maHD;
	private LocalDate ngayTaoHD;
	private TrangThaiHoaDon trangThaiHoaDon;
	private LocalDate ngayDat;
	private Ban ban;
	private NhanVien nhanVien;
	private KhachHang khachHang;
	private double tienCoc;
	private LocalTime gioDatBan;
	private KhuyenMai khuyenMai;

	public HoaDon(String maHD, LocalDate ngayTaoHD, TrangThaiHoaDon trangThaiHoaDon, LocalDate ngayDat, Ban ban,
			NhanVien nhanVien, KhachHang khachHang, double tienCoc, LocalTime gioDatBan, KhuyenMai khuyenMai) {
		super();
		this.maHD = maHD;
		this.ngayTaoHD = ngayTaoHD;
		this.trangThaiHoaDon = trangThaiHoaDon;
		this.ngayDat = ngayDat;
		this.ban = ban;
		this.nhanVien = nhanVien;
		this.khachHang = khachHang;
		this.tienCoc = tienCoc;
		this.gioDatBan = gioDatBan;
		this.khuyenMai = khuyenMai;
	}

	public HoaDon(String maHD,String tenKhachHang, String sdt, LocalDate ngayTaoHD, LocalTime gioDatBan, String maBan) {
		this.maHD=maHD;
		this.khachHang = new KhachHang();
		this.khachHang.setTenKH(tenKhachHang);  // Đảm bảo set tên khách hàng đúng thuộc tính
		this.khachHang.setsDT(sdt);  // Đảm bảo set đúng số điện thoại
		this.ngayTaoHD = ngayTaoHD;
		this.gioDatBan = gioDatBan;
		this.ban = new Ban();
		this.ban.setMaBan(maBan);
	}

	public String getTenKH() {
		return khachHang.getTenKH();
	}
	public String getSDT() {
		return khachHang.getsDT();
	}
	public String getMaBan() {
		return ban.getMaBan();
	}

	public HoaDon() {
		super();
	}
    public String getMaHD() {
		return maHD;
	}

	public void setMaHD(String maHD) {
		this.maHD = maHD;
	}

	public LocalDate getNgayTaoHD() {
		return ngayTaoHD;
	}

	public void setNgayTaoHD(LocalDate ngayTaoHD) {
		this.ngayTaoHD = ngayTaoHD;
	}

	public TrangThaiHoaDon getTrangThaiHoaDon() {
		return trangThaiHoaDon;
	}

	public void setTrangThaiHoaDon(TrangThaiHoaDon trangThaiHoaDon) {
		this.trangThaiHoaDon = trangThaiHoaDon;
	}

	public LocalDate getNgayDat() {
		return ngayDat;
	}

	public void setNgayDat(LocalDate ngayDat) {
		this.ngayDat = ngayDat;
	}

	public Ban getBan() {
		return ban;
	}

	public void setBan(Ban ban) {
		this.ban = ban;
	}

	public NhanVien getNhanVien() {
		return nhanVien;
	}

	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}

	public KhachHang getKhachHang() {
		return khachHang;
	}

	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}

	public double getTienCoc() {
		return tienCoc;
	}

	public void setTienCoc(double tienCoc) {
		this.tienCoc = tienCoc;
	}

	public LocalTime getGioDatBan() {
		return gioDatBan;
	}

	public void setGioDatBan(LocalTime gioDatBan) {
		this.gioDatBan = gioDatBan;
	}

	public KhuyenMai getKhuyenMai() {
		return khuyenMai;
	}

	public void setKhuyenMai(KhuyenMai khuyenMai) {
		this.khuyenMai = khuyenMai;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maHD);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HoaDon other = (HoaDon) obj;
		return Objects.equals(maHD, other.maHD);
	}

	@Override
	public String toString() {
		return "HoaDon [maHD=" + maHD + ", ngayTaoHD=" + ngayTaoHD + ", trangThaiHoaDon=" + trangThaiHoaDon
				+ ", ngayDat=" + ngayDat + ", ban=" + ban + ", nhanVien=" + nhanVien + ", khachHang=" + khachHang
				+ ", tienCoc=" + tienCoc + ", gioDatBan=" + gioDatBan + ", khuyenMai=" + khuyenMai + "]";
	}

}
