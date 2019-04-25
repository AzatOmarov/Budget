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
        top: "260px"
      }, 
      advice : {
        width: "max",   
        position: "absolute",  
        left: "40px",
        top: "260px"
      } 
    }

    const inputFields = {
        commonSets : {
            width: "256px",
            height: "35px",
            borderRadius: "5px",
            border: "solid 1px #000000",
            backgroundColor: "white",
          },
          nameField : {
            position: "absolute",
            top: "260px",
            left : "25px"
          }
    }

      


class NewPassword extends React.Component {
    constructor(){
        super()
        this.state={
            newPass: ""
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
                        <p style={Object.assign({}, commonSets, nameDescs)}>New password:</p> 
                    </div> 
                    <div className="col-3">
                        <input 
                            style={Object.assign({},fieldCommons, nameField)}
                            type="text" 
                            value={this.state.newPass}
                            name="name"
                            placeholder=""
                            onChange={this.handleChange}/>
                    </div>        
                    {/* <div className="col-7">
                        <p style={Object.assign({}, commonSets, advice)}>Make sure that you fill out all the fields before you leave this page</p> 
                    </div>  */}
                </div>
            )
        }
    }
    
export default NewPassword;
