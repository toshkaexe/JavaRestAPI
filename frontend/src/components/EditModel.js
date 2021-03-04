import React, {Component} from 'react';
import {Modal, Button, Row,Col, Form} from 'react-bootstrap';

import Snackbar from '@material-ui/core/Snackbar';
import IconButton from '@material-ui/core/IconButton';

export class EditModel extends Component {

    constructor(props){
        super(props);
        this.state = {snackbaropen: false, snabarmsg: ''};
        this.handleSubmit=this.handleSubmit.bind(this);
    }

    snackbarClose = (event) => {
        this.setState({snackbaropen: false});
    };
    handleSubmit(event){
        event.preventDefault();
        fetch('http://localhost:8080/users', {
            method: 'POST',
            headers: {
                'Accept': 'application/json',
                'Content-Type:': 'application/json'
            }, 
            body: JSON.stringify({
                DepartmentID: null,
                DemartmentName: event.target.DemartmentName.value
            })
        })
        .then(res => res.json())
        .then((result)=>
        {
            this.setState({snackbaropen: true, })
        })
    }


}
