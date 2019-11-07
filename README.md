# FSD-SBA
Mentor On Demand (FSD SBA)

1. FrontEnd Source code

    iiht_fsd_sba\frontend

2. Mid Tier Source code of all Microservices

    10001    registry

    8002    account

    8003    auth

    8004    course

    8005    gateway

    8006    payment

3. Screen shots of Usage of Post Man tool to test each End Point of all Microservices

    delivery screens
    
4. Few Steps on how to run the solution.

    mvn clean package

    mvn dockerfile:build
    
    docker run -d --name=registry -p 10001:10001 registry:latest
    
    docker run -d --name=account --link registry -p 8002:8002 account:latest
    
    docker run -d --name=auth --link registry -p 8003:8003 auth:latest
        
    docker run -d --name=course --link registry -p 8004:8004 course:latest
	
	docker run -d --name=gateway --link registry -p 8005:8005 gateway:latest
    
    docker run -d --name=payment --link registry -p 8006:8006 payment:latest
    
5. Test code of Angular and Mid Tier need to be included

    Run ng test to execute the frontend test
    
    Run mvn clean test to execute the backend test

6. Jmeter’s JMX file to test atleast one REST End point, and Screenshot of report
    
    delivery screens
    
7. Dockerfile

	iiht_fsd_sba/backend/account/Dockerfile

    iiht_fsd_sba/backend/auth/Dockerfile
	
	iiht_fsd_sba/backend/course/Dockerfile

    iiht_fsd_sba/backend/gateway/Dockerfile

    iiht_fsd_sba/backend/payment/Dockerfile
	
    iiht_fsd_sba/backend/registry/Dockerfile

8. Jenkinsfile or Jenkins UI ScreenShot

    delivery screens

9. URL where the Project is deployed

    http://localhost:4200/

