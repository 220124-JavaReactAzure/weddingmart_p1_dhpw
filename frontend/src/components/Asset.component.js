import React, { Component } from 'react';

export default class AssetComponent extends Component {
    constructor(props) {
        super(props)
    }

    render() {
        return (
            <div>
			{this.props.id}: {this.props.description}: {this.props.name}: Email {this.props.email} or Call {this.props.phone}, ${this.props.price}, located {this.props.address}
            </div>
        )
    }
}