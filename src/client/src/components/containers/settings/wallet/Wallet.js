import React, {Component} from 'react';

import NewWallet from '../../../UIComponents/modal/NewWallet.js';

class Wallet extends Component {
    render() {
        return (
            <div className="container">
                <div className="row">
                    <div className="col-12">
                        <div className="main-block-into">
                            <h4>Wallet</h4>
                            <NewWallet/>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default Wallet;