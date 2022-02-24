import React, { Component } from 'react';
import axios from 'axios';

import WeddingComponent from './Wedding.component';
import AssetComponent from './Asset.component';
import AssetBookingComponent from './AssetBooking.component';

export default class AssetAvailabilityComponent extends Component {
    constructor(props) {
        super(props);
		this.state = {
			weddings: [],
			assets: [],
			assetBookings: []
		};
    }
	
	async componentDidMount() {
        await fetch('http://localhost:8080/WeddingMart/wedding')
    .then(res => res.json())
            .then((res) => {
                this.setState({ 
                    weddings: res
                })
            });
		await fetch('http://localhost:8080/WeddingMart/asset')
    .then(res => res.json())
            .then((res) => {
                this.setState({ 
                    assets: res
                })
            });
		await fetch('http://localhost:8080/WeddingMart/assetBooking')
    .then(res => res.json())
            .then((res) => {
                this.setState({ 
                    assetBookings: res
                })
            });
	}
	
	renderWeddings() {
		const weddingList = [];
		this.state.weddings.forEach((wedding) => {
			let id = wedding.id;
			let budget = wedding.budget;
			let weddingDate = wedding.weddingDate;
			let rsvpByDate = wedding.rsvpByDate;
			let key = wedding.id.value;
			weddingList.push(<WeddingComponent id={id} budget={budget} date={weddingDate} rsvp={rsvpByDate} key={key} />);
		})
		return weddingList;
	}
	
	renderAssets() {
		const assetList = [];
		this.state.assets.forEach((asset) => {
			let id = asset.id;
			let email = asset.email;
			let name = asset.name;
			let phone = asset.phone;
			let price = asset.price;
			let address = asset.address;
			let description = asset.type.description;
			let key = asset.id.value;
			assetList.push(<AssetComponent id={id} email={email} name={name} phone={phone} price={price} address={address} description={description} key={key} />);
		})
		return assetList;
	}
	
	renderAssetBookings() {
		const assetBookingList = [];
		this.state.assetBookings.forEach((assetBooking) => {
			let id = assetBooking.id;
			let key = assetBooking.id.value;
			let asset_id = assetBooking.asset.id;
			let wedding_id = assetBooking.wedding.id;
			let booking_date = assetBooking.wedding.weddingDate;
			assetBookingList.push(<AssetBookingComponent id={id} key={key} asset_id={asset_id} wedding_id={wedding_id} booking_date={booking_date} />);
		})
		return assetBookingList;
	}

    render() {
        return (
            <div>
			Weddings: <br/>
			{this.renderWeddings()}
			Assets: <br/>
			{this.renderAssets()}
			AssetBookings: <br/>
			{this.renderAssetBookings()}
            </div>
        )
    }
}