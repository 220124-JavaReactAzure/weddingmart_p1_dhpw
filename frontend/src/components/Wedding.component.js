import React, { Component } from 'react';
import axios from 'axios';

export default class WeddingComponent extends Component {
    constructor(props) {
        super(props)
    }

    render() {
        return (
            <div>
			id={this.props.id} budget={this.props.budget} date={this.props.weddingDate} rsvp={this.props.rsvpByDate}
            </div>
        )
    }
}