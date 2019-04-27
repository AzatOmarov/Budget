import React, {Component} from 'react';
import Title from '../../UIComponents/header/Title.js';
import Slogan from '../../UIComponents/header/Slogan.js';
import NewTransaction from '../../UIComponents/modal/NewTransaction.js';

import DatePicker from 'react-datepicker';
import 'react-datepicker/dist/react-datepicker.css';

import axios from 'axios';

class Transactions extends Component {

    constructor(props) {
        super(props);
        this.state = {
            transactions: [],
            typeTransaction: 'all',
            startDate: new Date()
        };
        this.handleChange = this.handleChange.bind(this);
        this.handleChangeDate = this.handleChangeDate.bind(this);
    }

    componentWillMount() {
        axios.get("http://localhost:2030/api/transactions/wallet/1").then(res => {
            const transactions = res.data;
            this.setState({transactions: transactions});
        })
    }

    handleChange(event) {
        console.log("Event.target.value is", event.target.value);
        this.setState({typeTransaction: event.target.value});
    }

    handleChangeDate(date) {
        console.log("Date", date);
        this.setState({startDate: date});
    }

    render() {
        const {transactions} = this.state;
        const listItems = transactions.map((d) =>
            <tr key={d.amount}>
                <td>{d.amount}</td>
                <td>{d.categoryName}</td>
                <td>{d.description}</td>
            </tr>
        );

        return (
            <div className="container">
                <div className="row">
                    <div className="col-5">
                        <Title/>
                    </div>
                    <div className="col-7">
                        <Slogan/>
                    </div>
                </div>
                <div className="frame-big">
                    <div className="row">
                        <div className="col-12">
                            <div className="main-block">

                                <div className="row top-space">
                                    <div className="col-12">
                                        <h3>Transactions</h3>
                                        <NewTransaction/>
                                    </div>
                                </div>

                                <div className="row top-space">
                                    <div className="col-7">
                                        <form>
                                            <div className="form-row">
                                                <div className="col">
                                                    <p className="title">Date</p>
                                                    <DatePicker className="form-control" id="dateTransaction"
                                                                selected={this.state.startDate}
                                                                onChange={this.handleChangeDate}
                                                                dateFormat="MMMM d, yyyy"
                                                                todayButton={"Today"}
                                                    />
                                                </div>
                                                <div className="col">
                                                    <p className="title">Type Transaction</p>
                                                    <select className="form-control" id="typeTransaction"
                                                            value={this.state.typeTransaction}
                                                            onChange={this.handleChange}>
                                                        <option value={"all"}>All</option>
                                                        <option value={"Income"}>Income</option>
                                                        <option value={"Expenses"}>Expenses</option>
                                                    </select>
                                                </div>
                                                <div className="col">
                                                    <p className="title">Sum</p>
                                                    <input type="text" className="form-control" id="sumTransaction"
                                                           placeholder=">200,00"/>
                                                </div>
                                            </div>
                                        </form>
                                    </div>
                                    <div className="col-5"/>
                                </div>

                                <div className="row top-space">
                                    <div className="col-9 top-space">
                                        <table className="table table-bordered">
                                            <thead>
                                            <tr>
                                                <th scope="col">Sum</th>
                                                <th scope="col">Category</th>
                                                <th scope="col">Description</th>
                                            </tr>
                                            </thead>
                                            <tbody
                                                style={listItems.length ? {} : {display: 'none'}}>{listItems}
                                            </tbody>
                                        </table>
                                    </div>
                                    <div className="col-3"/>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default Transactions;