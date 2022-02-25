import React, { Component } from 'react';

import WeddingComponent from './Wedding.component';
import AssetComponent from './Asset.component';
import AssetBookingComponent from './AssetBooking.component';

export default class AssetAvailabilityComponent extends Component {
    constructor(props) {
        super(props);
		this.state = {
			weddings: [],
			assets: [],
			assetBookings: [],
			assetTypes: [],
			availableAssets: [],
			startDate: '1970-01-01',
			endDate: '1970-01-01'
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
		await fetch('http://localhost:8080/WeddingMart/assetType')
    .then(res => res.json())
            .then((res) => {
                this.setState({ 
                    assetTypes: res
                })
            });
	}
	
	capitalize(str) {
		return str.charAt(0).toUpperCase() + str.slice(1);
	}
	
	renderWeddings() {
		const weddingList = [];
		this.state.weddings.forEach((wedding) => {
			let id = wedding.id;
			let budget = wedding.budget;
			let weddingDate = wedding.weddingDate;
			let rsvpByDate = wedding.rsvpByDate;
			let key = wedding.id;
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
			let key = asset.id;
			assetList.push(<AssetComponent id={id} email={email} name={name} phone={phone} price={price} address={address} description={this.capitalize(description)} key={key} />);
		})
		return assetList;
	}
	
	renderAvailableAssets() {
		const assetList = [];
		this.state.availableAssets.forEach((asset) => {
			let id = asset.id;
			let email = asset.email;
			let name = asset.name;
			let phone = asset.phone;
			let price = asset.price;
			let address = asset.address;
			let description = asset.type.description;
			let key = asset.id;
			assetList.push(<AssetComponent id={id} email={email} name={name} phone={phone} price={price} address={address} description={this.capitalize(description)} key={key} />);
		})
		return assetList;
	}
	
	renderAssetBookings() {
		const assetBookingList = [];
		this.state.assetBookings.forEach((assetBooking) => {
			let id = assetBooking.id;
			let key = assetBooking.id;
			let asset_id = assetBooking.asset.id;
			let wedding_id = assetBooking.wedding.id;
			let booking_date = assetBooking.wedding.weddingDate;
			assetBookingList.push(<AssetBookingComponent id={id} key={key} asset_id={asset_id} wedding_id={wedding_id} booking_date={booking_date} />);
		})
		return assetBookingList;
	}
	
	renderAssetTypes() {
		const assetTypeList = [];
		this.state.assetTypes.forEach((assetType) => {
			let id = assetType.id;
			let key = assetType.id;
			let description = assetType.description;
			assetTypeList.push(<option value={id}>{this.capitalize(description)}</option>);
		});
		return assetTypeList;
	}
	
	handleStart = event => {
		this.setState({ startDate: event.target.value }); };
	
	handleEnd = event => {
		this.setState({ endDate: event.target.value }); };
		
	findClicked = event => {
		this.findAvailableAssets();
	};
	
	findAvailableAssets() {
		let allAssetList = [];
		let unavailableAssetList = [];
		let confirmedAvailableAssetIDList = [];
		this.state.availableAssets = [];

		this.state.assetBookings.forEach((assetBooking) => {
			let id = assetBooking.asset.id;
			let date = new Date( assetBooking.wedding.weddingDate );
			let start = new Date( this.state.startDate );
			let end = new Date( this.state.endDate ); 
			if ( this.state.startDate.localeCompare(assetBooking.wedding.weddingDate) == 0 
				|| this.state.endDate.localeCompare(assetBooking.wedding.weddingDate) == 0
				|| ( date > start && date < end ) ) {
					unavailableAssetList.push(id);
			}
		})
		
		allAssetList = this.state.assets;
		allAssetList.sort();
		
		allAssetList.forEach(asset => {
			for (let i=0; i <= unavailableAssetList.length; i++) {
				if (asset.id == unavailableAssetList[i]) {
					unavailableAssetList.shift();
					return;
				}
				if (asset.id > unavailableAssetList[i]) {
					i = unavailableAssetList.length;
				}
			}
			this.state.availableAssets.push(asset);
		})
		this.forceUpdate();
	}

    render() {
        return (
            <div>
			Find assets available between <input onChange={this.handleStart} type="date"/> and <input onChange={this.handleEnd} type="date"/> 
			<input type="submit" value="Find" onClick={this.findClicked} /> <br/>
			<b>Assets Available in your selected Date range:</b> <br/>
			{this.renderAvailableAssets()}
			<b>Weddings:</b> <br/>
			{this.renderWeddings()}
			<b>Assets:</b> <br/>
			{this.renderAssets()}
			<b>AssetBookings:</b> <br/>
			{this.renderAssetBookings()}
            </div>
        )
    }
}