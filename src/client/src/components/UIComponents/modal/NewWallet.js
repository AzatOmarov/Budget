import React, {Component} from 'react';
import styled from 'styled-components';
import axios from "axios";

const Wrapper = styled.div`
    position: relative;
`;

const LinkWrapper = styled.div`
    position: relative;
`;

class NewWallet extends Component {

    constructor(props) {
        super(props);
        this.state = {
            userId: 1,
            currencyName: 'RUB'
        };

        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    handleChange(event) {
        this.setState({currencyName: event.target.value});
    };

    handleSubmit(event) {
        event.preventDefault();

        console.log(this.state.userId);
        console.log(this.state.currencyName);

        const config = {
            headers: {'Content-Type': 'application/json'}
        };

        const resp = axios.post('http://localhost:2030/api/wallets',
            {
                userId: this.state.userId,
                currencyName: this.state.currencyName
            }, config)
            .then(function (response) {
                console.log(response);
            })
            .catch(function (error) {
                console.log(error);
            });

        console.log(resp);
    }

    render() {
        return (
            <Wrapper>
                <LinkWrapper>
                    <a href="" data-toggle="modal" data-target="#newWalletModalCenter">Add new wallet</a>
                </LinkWrapper>

                <div className="modal fade" id="newWalletModalCenter" tabIndex="-1" role="dialog"
                     aria-labelledby="newWalletModalCenterTitle" aria-hidden="true">
                    <div className="modal-dialog modal-dialog-centered" role="document">
                        <div className="modal-content">
                            <div className="modal-header">
                                <h5 className="modal-title" id="newWalletModalLongTitle">New wallet</h5>
                                <button type="button" className="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div className="modal-body">

                                <form className="needs-validation" onSubmit={this.handleSubmit}>
                                    <div className="form-group">
                                        <label htmlFor="newWalletDropdownCurrency">Set main currency</label>
                                        <select className="form-control"
                                                id="newWalletDropdownCurrency"
                                                value={this.state.currencyName}
                                                onChange={this.handleChange}
                                                aria-describedby="currencyHelp"
                                                placeholder="Set main currency"
                                                required>
                                            <option value={"RUB"}>RUB</option>
                                            <option value={"USD"}>USD</option>
                                            <option value={"EUR"}>EUR</option>
                                        </select>
                                    </div>
                                    <div className="form-group">
                                        <label htmlFor="newWalletInputBalance">Set initial balance</label>
                                        <input className="form-control" id="newWalletInputBalance"
                                               placeholder="Balance" required/>
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

export default NewWallet;