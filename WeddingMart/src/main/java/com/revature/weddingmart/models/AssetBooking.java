package com.revature.weddingmart.models;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "asset_booking")
public class AssetBooking {
	@ManyToOne(optional = false)
	@JoinColumn(name = "asset_id", unique = false, nullable = false, updatable = false)
	private Asset asset;
	@ManyToOne(optional = false)
	@JoinColumn(name = "wedding_id", unique = false, nullable = false, updatable = false)
	private Wedding wedding;
	@Column(name = "booking_date")
	private Date date;

	public Asset getAsset() {
		return asset;
	}

	public void setAsset(Asset asset) {
		this.asset = asset;
	}

	public Wedding getWedding() {
		return wedding;
	}

	public void setWedding(Wedding wedding) {
		this.wedding = wedding;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public int hashCode() {
		return Objects.hash(asset, date, wedding);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AssetBooking other = (AssetBooking) obj;
		return Objects.equals(asset, other.asset) && Objects.equals(date, other.date)
				&& Objects.equals(wedding, other.wedding);
	}

	@Override
	public String toString() {
		return "AssetBooking [asset=" + asset + ", wedding=" + wedding + ", date=" + date + "]";
	}

}
