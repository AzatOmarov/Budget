import React from 'react';

const fieldDescriptions = {
    commonSets: {
        width: "145px",
        height: "17px",
        fontFamily: "Myriad Pro",
        fontSize: "25px",
        fontWeight: "normal",
        fontStyle: "normal",
        fontStretch: "50%",
        lineHeight: "1",
        letterSpacing: "normal",
        textAlign: "left",
        color: "#000000",
      },
      nameDescs : {
        position: "absolute",  
        left: "50px",
        top: "120px"
      }, 
      advice : {
        width: "max",   
        position: "absolute",  
        left: "40px",
        top: "120px"
      } 
    }

    const inputFields = {
        commonSets : {
            fontSize: "20px",
            width: "256px",
            height: "35px",
            borderRadius: "5px",
            border: "solid 1px #000000",
            backgroundColor: "white",
          },
          nameField : {
            position: "absolute",
            top: "110px",
            left : "25px"
          }
    }

class EmailInput extends React.Component {
    constructor(){
        super()
        this.state={
            email: ""
        }
        this.handleChange = this.handleChange.bind(this);

    }
    handleChange(event){
        const{name, value} = event.target
        this.setState({[name]:value})
    }

    render(){
        const {commonSets : commonSets, nameDescs : nameDescs} = fieldDescriptions;
        const {commonSets : fieldCommons, nameField : nameField} = inputFields;
            return (
                <div className="row">
                    <div className="col-2">
                        <p style={Object.assign({}, commonSets, nameDescs)}>Email:</p> 
                    </div> 
                    <div className="col-3">
                        <input 
                            style={Object.assign({},fieldCommons, nameField)}
                            type="text" 
                            value={this.state.email}
                            name="email"
                            placeholder=""
                            onChange={this.handleChange}/>
                    </div>        
                </div>
            )
        }
    }
    
export default EmailInput;
