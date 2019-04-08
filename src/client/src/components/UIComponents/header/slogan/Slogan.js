import React, {Component} from 'react';
import styled from "styled-components";

const Wrapper = styled.div`
    position: relative;
    margin-top: 4%;
`;

const Name = styled.p`
    font-family: Sans-Serif;
    font-size: 25px;
    fontStyle: italic;
    text-align: right;
    color: #5f8420;
`;

class Slogan extends Component {
    render() {
        return (
            <Wrapper>
                <Name>The best way to keep your budget on track</Name>
            </Wrapper>
        )
    }
}

export default Slogan;