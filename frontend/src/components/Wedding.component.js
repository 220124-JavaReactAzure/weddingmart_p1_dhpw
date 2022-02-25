import React, { Component } from 'react';

export default class WeddingComponent extends Component {
    constructor(props) {
        super(props)
    }

    render() {
        return (
            <div>
			{this.props.id}: Date {this.props.date} / RSVP by {this.props.rsvp}, ${this.props.budget} 
            </div>
        )
    }
}