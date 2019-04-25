import React from 'react';
import styled from 'styled-components';


const Link = styled.a`
    text-decoration: underline;
    color: black;
    &:hover {
        color: white;
    }    
`;

const tspGroup = {
    row : {
        width: "148px",
        height: "25px",
        fontFamily: "Myriad Pro",
        fontSize: "22px",
        fontWeight: "normal",
        fontStyle: "normal",
        fontStretch: "normal",
        lineHeight: "normal",
        letterSpacing: "normal",
        textAlign: "left",
        position: "inherit",
        margin: "1% 1% 2% 1%"
    },

    cancel : {
        position: "absolute",
        top: "300px",
        left: "180px"
        
      },
      
    save : {
        position: "absolute",
        top: "300px",
        left: "360px"
      },
}

function CancelSave(){
    const {row : rowStyle, cancel : cancel, save : save} = tspGroup;
    return (
        <div className="container">
            <div className="row" style={rowStyle}>
                <div className="col-md-auto">
                    <Link href="">
                        <p style={cancel}>Cancel</p>
                    </Link>
                    <Link href="">
                        <p style={save}>Save</p>
                    </Link>
                </div>
            </div>  
        </div>
    )
}
export default CancelSave;
