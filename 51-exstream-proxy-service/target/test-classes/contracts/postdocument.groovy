import org.springframework.cloud.contract.spec.Contract

Contract.make {
	request {
		method POST()
		url "/document"
        body (	
			ClaimNumber: "312-36-300870",
			SendTo: "Bob G Smith",
			ToAddressLine1: "1409 Roper Mountain Road",
			ToState: "SC",
			ToZip: "29615",
			ReportedDate: "2018-07-06T00:00:00+00:00",
			PolicyTerm: "WorkersComp",
			PolicyNumber: "32-300869",
			PolicyExp: "08022019",
			ClaimantSignature: "surajprakash.a@hcl.com",
			DocuName: "MedicareLetter",
			ClaimantFullName: "Bob G Smith"
		)
		headers {
			contentType(applicationJson())
		}
	}
	response {
 		status 200
 		body (
        	FileName: "csdjsdjkbjsd",
			FileUrl: "sdsdfsdfsdfsdfsdf"
		)
		headers {
			contentType(applicationJson())
		} 
	}   
}