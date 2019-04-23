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
                                        <select className="form-control" id="newWalletDropdownCurrency"
                                                aria-describedby="currencyHelp" placeholder="Set main currency"
                                                required>

                                            <option selected>Choose...</option>
                                            <option>...</option>
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