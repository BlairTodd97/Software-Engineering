import React, {Component} from 'react';
import {Link, withRouter} from 'react-router-dom';
import {Button, Container, Form, FormGroup, Input, Label} from 'reactstrap';
import AppNavbar from './AppNavbar';

class UserEdit extends Component {

    emptyItem = {
        firstName: '',
        lastName: '',
        username: ''
    };

    constructor(props) {
        super(props);
        this.state = {
            item: this.emptyItem
        };
        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    async componentDidMount() {
        if(this.props.match.params.id !== 'new') {
            const user = await (await fetch(`/api/user/${this.props.match.params.id}`)).json();
            this.setState({item: user})
        }
    }

    handleChange(event) {
        const target = event.target;
        const value = target.value;
        const name = target.name;
        let item = {...this.state.item};
        item[name] = value;
        this.setState({item});
    }

    async handleSubmit(event) {
        event.preventDefault();
        const {item} = this.state;

        await fetch(`/api/user/${item.id}`, {
            method: (item.id) ? 'PUT' : 'POST',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(item),
        });
        this.props.history.push('/users')
    }

    render() {
        const {item} = this.state;
        const title = <h2>{item.id ? 'Edit User' : 'Add User'}</h2>;

        return <div>
            <AppNavbar/>
            <Container>
                {title}
                <Form onSubmit={this.handleSubmit}>
                    <FormGroup>
                        <Label for={"firstName"}>First Name</Label>
                        <Input type={"text"} name={"firstName"} id={"firstName"} value={item.firstName || ''} onChange={this.handleChange} autoComplete={"firstName"}/>
                    </FormGroup>
                    <FormGroup>
                        <Label for={"lastName"}>Last Name</Label>
                        <Input type={"text"} name={"lastName"} id={"lastName"} value={item.lastName || ''} onChange={this.handleChange} autoComplete={"lastName"}/>
                    </FormGroup>
                    <FormGroup>
                        <Label for={"username"}>Username</Label>
                        <Input type={"text"} name={"username"} id={"username"} value={item.username || ''} onChange={this.handleChange} autoComplete={"username"}/>
                    </FormGroup>
                    <FormGroup>
                        <Button color="primary" type="submit">Save</Button>{' '}
                        <Button color="secondary" tag={Link} to="/users">Cancel</Button>
                    </FormGroup>
                </Form>
            </Container>
        </div>
    }
}

export default withRouter(UserEdit)