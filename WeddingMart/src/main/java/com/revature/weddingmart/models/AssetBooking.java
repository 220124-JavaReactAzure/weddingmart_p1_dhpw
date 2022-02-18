package com.revature.weddingmart.models;

import java.util.Date;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "asset_booking")
public class AssetBooking {
	@Id
	@GeneratedValue
	private int id;
	@ManyToOne(optional = false, cascade = CascadeType.ALL)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JoinColumn(name = "asset_id", unique = false, nullable = false, updatable = false)
	private Asset asset;
	@ManyToOne(optional = false, cascade = CascadeType.ALL)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JoinColumn(name = "wedding_id", unique = false, nullable = false, updatable = false)
	private Wedding wedding;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	@Override
	public int hashCode() {
		return Objects.hash(asset, wedding);
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
		return Objects.equals(asset, other.asset)
				&& Objects.equals(wedding, other.wedding);
	}

	@Override
	public String toString() {
		return "AssetBooking [asset=" + asset + ", wedding=" + wedding + "]";
	}

}
