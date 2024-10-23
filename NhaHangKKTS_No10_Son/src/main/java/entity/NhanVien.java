package entity;

import java.time.LocalDate;
import java.util.Objects;

public class NhanVien {
	private String maNV;
	private String tenNV;
	private boolean gioiTinh;
	private String sDT;
	private String trangThai;
	private LocalDate ngayVaoLam;
	private LocalDate ngayNghiLam;
	private LocalDate ngaySinh;

	public NhanVien(String maNV, String tenNV, boolean gioiTinh, String sDT, String trangThai, LocalDate ngayVaoLam,
			LocalDate ngayNghiLam, LocalDate ngaySinh) {
		super();
		this.maNV = maNV;
		this.tenNV = tenNV;
		this.gioiTinh = gioiTinh;
		this.sDT = sDT;
		this.trangThai = trangThai;
		this.ngayVaoLam = ngayVaoLam;
		this.ngayNghiLam = ngayNghiLam;
		this.ngaySinh = ngaySinh;
	}

	public NhanVien() {
		super();
	}

	public String getMaNV() {
		return maNV;
	}

	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}

	public String getTenNV() {
		return tenNV;
	}

	public void setTenNV(String tenNV) {
		this.tenNV = tenNV;
	}

	public boolean isGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public String getsDT() {
		return sDT;
	}

	public void setsDT(String sDT) {
		this.sDT = sDT;
	}

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}

	public LocalDate getNgayVaoLam() {
		return ngayVaoLam;
	}

	public void setNgayVaoLam(LocalDate ngayVaoLam) {
		this.ngayVaoLam = ngayVaoLam;
	}

	public LocalDate getNgayNghiLam() {
		return ngayNghiLam;
	}

	public void setNgayNghiLam(LocalDate ngayNghiLam) {
		this.ngayNghiLam = ngayNghiLam;
	}

	public LocalDate getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(LocalDate ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maNV);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NhanVien other = (NhanVien) obj;
		return Objects.equals(maNV, other.maNV);
	}

	@Override
	public String toString() {
		return "NhanVien [maNV=" + maNV + ", tenNV=" + tenNV + ", gioiTinh=" + gioiTinh + ", sDT=" + sDT
				+ ", trangThai=" + trangThai + ", ngayVaoLam=" + ngayVaoLam + ", ngayNghiLam=" + ngayNghiLam
				+ ", ngaySinh=" + ngaySinh + "]";
	}

}
