import React, { Component } from 'react';

export default class AssetComponent extends Component {
    constructor(props) {
        super(props)
    }

    render() {
        return (
            <div>
			{this.props.id}: {this.props.description}: {this.props.name}: {this.props.email}, {this.props.phone}, {this.props.price}, address={this.props.address}
            </div>
        )
    }
}