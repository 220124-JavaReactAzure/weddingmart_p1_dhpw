import React, { Component } from 'react';

export default class AssetBookingComponent extends Component {
    constructor(props) {
        super(props)
    }

    render() {
        return (
            <div>
			id={this.props.id} asset_id={this.props.asset_id} wedding_id={this.props.wedding_id} booking_date={this.props.booking_date}
            </div>
        )
    }
}