import React, { Component } from 'react';

export default class AssetComponent extends Component {
    constructor(props) {
        super(props)
    }

    render() {
        return (
            <div>
			id={this.props.id} email={this.props.email} name={this.props.name} phone={this.props.phone} price={this.props.price} address={this.props.address} description={this.props.description}
            </div>
        )
    }
}