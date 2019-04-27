import React, {Component} from 'react';
import styled from 'styled-components';

import DatePicker from 'react-datepicker';
import 'react-datepicker/dist/react-datepicker.css';

import axios from "axios";

const Wrapper = styled.div`
    position: relative;
`;

const LinkWrapper = styled.div`
    position: relative;
`;

class NewTransaction extends Component {

    constructor(props) {
        super(props);
        this.state = {};

        this.handleSubmit = this.handleSubmit.bind(this);
    }

    handleSubmit(event) {
        event.preventDefault();
        // axios.get("http://localhost:2030/api/users/email/" + this.state.email).then(res => {
        //     const user = res.data;
        //     this.setState({user});
        // });
    }

    render() {
        return (
            <Wrapper>
                <LinkWrapper>
                    <a href="" data-toggle="modal" data-target="#newTransactionModalCenter">Add new transaction +</a>
                </LinkWrapper>

                <div className="modal fade" id="newTransactionModalCenter" tabIndex="-1" role="dialog"
                     aria-labelledby="newTransactionModalCenterTitle" aria-hidden="true">
                    <div className="modal-dialog modal-dialog-centered" role="document">
                        <div className="modal-content">
                            <div className="modal-header">
                                <h5 className="modal-title" id="newTransactionModalLongTitle">New transaction</h5>
                                <button type="button" className="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div className="modal-body">

                                <form className="needs-validation" onSubmit={this.handleSubmit}>
                                    <div className="form-group position-center">
                                        <label htmlFor="newTransactionDropdownDate">Date</label>&#8195;&#8195;
                                        <DatePicker className="form-control" id="newTransactionDropdownDate"
                                                    selected={this.state.startDate}
                                                    onChange={this.handleChangeDate}
                                                    dateFormat="MMMM d, yyyy"
                                                    todayButton={"Today"}
                                                    required
                                        />
                                    </div>

                                    <div className="form-group">
                                        <label htmlFor="newTransactionDropdownTypeTransaction" className="title">Type Transaction</label>
                                        <select className="form-control" id="newTransactionDropdownTypeTransaction"
                                                value={this.state.typeTransaction}
                                                onChange={this.handleChange}>
                                            <option value={"all"}>All</option>
                                            <option value={"Income"}>Income</option>
                                            <option value={"Expenses"}>Expenses</option>
                                        </select>
                                    </div>

                                    <div className="form-group">
                                        <label htmlFor="newTransactionDropdownCategory" className="title">Category</label>
                                        <select className="form-control" id="newTransactionDropdownCategory"
                                                value={this.state.category}
                                                onChange={this.handleChange}>
                                            <option value={"Salary"}>Salary</option>
                                            <option value={"Bonus"}>Bonus</option>
                                        </select>
                                    </div>

                                    <div className="form-group">
                                        <label htmlFor="newTransactionInputSum">Sum</label>
                                        <input className="form-control" id="newTransactionInputSum"
                                               placeholder="200.00" required/>
                                    </div>

                                    <div className="form-group">
                                        <label htmlFor="newTransactionInputDescription">Description</label>
                                        <input className="form-control" id="newTransactionInputDescription"
                                               placeholder="Add description..." required/>
                                    </div>

                                    <input className="btn btn-primary" type="submit" value="Add"/>
                                </form>

                            </div>
                        </div>
                    </div>
                </div>
            </Wrapper>
        )
    }
}

export default NewTransaction;