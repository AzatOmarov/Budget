import React from 'react';
import styled from 'styled-components';


const Link = styled.a`
    text-decoration: underline;
    color: #273939;
    &:hover {
        color: #a1f80b;
    }    
`;

const tspGroup = {
    row : {
        width: "148px",
        height: "25px",
        fontFamily: "Myriad Pro",
        fontSize: "28px",
        fontWeight: "normal",
        fontStyle: "normal",
        fontStretch: "normal",
        lineHeight: "normal",
        letterSpacing: "normal",
        textAlign: "left",
        position: "inherit",
        margin: "1% 1% 2% 1%"
    },
    transactions : {
        position: "absolute",
        left: "5px"
      },
    settings : {
        position: "absolute",
        left: "212px"
      },
    profile : {
        position: "absolute",
        left: "350px"
      },
    wallet : {
      width: "258px",
      position: "absolute",
      left: "470px",
      letterSpacing: "0em",
      wordSpacing: "1px"
    },
    categories : {
        width: "258px",
        position: "absolute",
        left: "650px"
      }
      
}

function TSPButtonGroup(){
    const {row : row, transactions : transactions, settings : settings, profile : profile, wallet : wallet, categories : categories } = tspGroup;
    return (
        <div className="container">
            <div className="row" style={row}>
                <div className="col-md-auto">
                    <Link href="">
                        <p style={transactions}>Transactions</p>
                    </Link>
                    <Link href="">
                        <p style={settings}>Settings</p>
                    </Link>
                    <Link href="">
                        <p style={profile}>Profile</p>
                    </Link>
                    <Link href="">
                        <p style={wallet}>My Wallet</p>
                    </Link>
                    <Link href="">
                        <p style={categories}>Categories</p>
                    </Link>
                </div>
            </div>  
        </div>
    )
}
export default TSPButtonGroup;
