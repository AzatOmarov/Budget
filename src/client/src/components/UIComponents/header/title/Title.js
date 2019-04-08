import React, {Component} from 'react';
import styled from 'styled-components'

const Wrapper = styled.div`
    position: relative;
`;

const Name = styled.p`
    font-family: Sans-Serif;
    font-size: 50px;
    text-align: left;
    color: #5f8420;
`;

class Title extends Component {
    render() {
        return (
            <Wrapper>
                <Name>Budget</Name>
            </Wrapper>
        )
    }
}

export default Title;

// const Title = ({className}) => {
//     return (
//         <div className={className}>
//             <div className={"title__position"}>
//                 <p className={"title__name"}>Budget</p>
//             </div>
//         </div>
//     )
// };
//
// const StyledTitle = styled(Title)`
//     .title__position{
//         position: relative;
//     }
//
//     .title__name{
//         font-family: Sans-Serif;
//         font-size: 50px;
//         text-align: left;
//         color: #5f8420;
//     }
// `;
//
// export default StyledTitle;