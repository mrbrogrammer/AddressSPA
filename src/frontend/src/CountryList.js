import React, { Component } from 'react';
import { Button, ButtonGroup, Container, Table } from 'reactstrap';
import AppNavbar from './AppNavbar';
import { Link } from 'react-router-dom';

class CountryList extends Component {

    constructor(props) {
        super(props);
        this.state = {countries: []};
        this.remove = this.remove.bind(this);
    }

    componentDidMount() {
        fetch('/api/v1/countries')
            .then(response => response.json())
            .then(data => this.setState({countries: data}));
    }
}
export default CountryList;