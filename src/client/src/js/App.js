import React, {Component} from "react";
import axios from "axios"

class App extends Component {
    constructor() {
        super();
        this.state = {
            transactions: []
        };
        this.handleClick = this.handleClick.bind(this);
    }

    handleClick(event) {
        event.preventDefault();

        axios.get("http://localhost:8080/api/transactions/wallet/1").then(res => {
            const transactions = res.data;
            this.setState({transactions: transactions});
        })
    }

    render() {
        const {transactions} = this.state;
        const listItems = transactions.map((d) => <li
            key={d.amount}>{d.amount}&emsp;{d.categoryName}&emsp;{d.description}</li>);
        return (
            <div>
                <button onClick={this.handleClick} type="submit">Get transactions</button>
                <ul style={listItems.length ? {} : {display: 'none'}}>{listItems}</ul>
            </div>
        )
    }
}

export default App;
