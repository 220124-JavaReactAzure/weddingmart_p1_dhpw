import React, { Component } from 'react';

export default class AssetBookingComponent extends Component {
    constructor(props) {
        super(props)
    }

    render() {
        return (
            <div>
			{this.props.id}: Asset {this.props.asset_id} booked by Wedding {this.props.wedding_id} for {this.props.booking_date}
            </div>
        )
    }
}