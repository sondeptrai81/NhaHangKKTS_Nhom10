package entity;

import java.util.Objects;

public class Ban {
	private String maBan;
	private int soLuongGhe;
	private KhuVuc khuVuc;
	private TrangThaiBan trangThaiBan;
	public String getMaBan() {
		return maBan;
	}
	public void setMaBan(String maBan) {
		this.maBan = maBan;
	}
	public int getSoLuongGhe() {
		return soLuongGhe;
	}
	public void setSoLuongGhe(int soLuongGhe) {
		this.soLuongGhe = soLuongGhe;
	}
	public KhuVuc getKhuVuc() {
		return khuVuc;
	}
	public void setKhuVuc(KhuVuc khuVuc) {
		this.khuVuc = khuVuc;
	}
	public TrangThaiBan getTrangThaiBan() {
		return trangThaiBan;
	}

	public void setTrangThaiBan(TrangThaiBan trangThaiBan) {
		this.trangThaiBan = trangThaiBan;
	}
	public Ban(String maBan, int soLuongGhe, KhuVuc khuVuc, TrangThaiBan trangThaiBan) {
		super();
		this.maBan = maBan;
		this.soLuongGhe = soLuongGhe;
		this.khuVuc = khuVuc;
		this.trangThaiBan = trangThaiBan;
	}
	public Ban(String maBan) {
		super();
		this.maBan = maBan;
	}


	public Ban() {
		super();
	}

	@Override
	public int hashCode() {
		return Objects.hash(maBan);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ban other = (Ban) obj;
		return Objects.equals(maBan, other.maBan);
	}

	@Override
	public String toString() {
		return "Ban [maBan=" + maBan + ", soLuongGhe=" + soLuongGhe + ", khuVuc=" + khuVuc + ", trangThaiBan="
				+ trangThaiBan + "]";
	}

}
