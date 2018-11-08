package org.firstinspires.ftc.teamcode.AutonomousOpModes;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.NormalizedRGBA;
import com.qualcomm.robotcore.util.ElapsedTime;
import org.firstinspires.ftc.teamcode.HardwareRobot;

@com.qualcomm.robotcore.eventloop.opmode.Autonomous(name="Autonomous2")
//@Disabled
public class Autonomous2 extends LinearOpMode {

    HardwareRobot robot = new HardwareRobot();
    private ElapsedTime runtime = new ElapsedTime();

    @Override
    public void runOpMode() {

        robot.init(hardwareMap);

        //Stop and reset Encoders
        robot.frontleft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.backleft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.frontright.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.backright.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.rightlift.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.leftlift.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        //Run using Encoders
        robot.frontleft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.backleft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.frontright.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.backright.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.rightlift.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.leftlift.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        waitForStart();

        encoderDrive(.3, -37, 37, -37, 37, 2);
        encoderDrive(robot.DRIVE_SPEED, 33, 33, 33, 33, 2);
        encoderDrive(robot.DRIVE_SPEED, -150, 150, -150, 150, 2);

        //Make leftlift and rightlift go down using encoders
        /*robot.leftlift.setTargetPosition(3400);
        robot.rightlift.setTargetPosition(3400);

        robot.leftlift.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.rightlift.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        robot.leftlift.setPower(1);
        robot.rightlift.setPower(1);

        while (robot.leftlift.isBusy() && robot.rightlift.isBusy()){
        }

        robot.ZeroPower();

        // Strafe left 4 inches
        encoderDrive(robot.DRIVE_SPEED, 4, 4, -4, -4, 5);
        // Go Forward 4 inches
        encoderDrive(robot.DRIVE_SPEED, -4, 4,-4, 4, 2);
        // Strafe right 4 inches
        encoderDrive(robot.DRIVE_SPEED, -4, -4, 4, 4, 2);
        //Drive forward 19 inches
        encoderDrive(robot.DRIVE_SPEED, -18, 18, -18, 18, 2);

        //Set servo positions so the color sensors are in place
        robot.servoleft.setPosition(.855);
        robot.servoright.setPosition(.05);
        sleep(1000);

        //Using Color Sensors to compare the red values between all three
        NormalizedRGBA color_left = robot.CSleft.getNormalizedColors();
        NormalizedRGBA color_center = robot.CScenter.getNormalizedColors();
        NormalizedRGBA color_right = robot.CSright.getNormalizedColors();
        sleep(500);

        color_center.red *= 15;

        //If CSleft has more red than the other two, move to the left and then forward
        if (color_left.red < color_center.red  && color_left.red < color_right.red) {
            //Hit left?
            telemetry.addLine("Hit left");
            telemetry.addData("red center", color_center.red);
            telemetry.addData("red left", color_left.red);
            telemetry.addData("red right", color_right.red);
            telemetry.update();
            sleep(15000);
        }

        //If CScenter has more red than the other two, move forward
        else if (color_center.red < color_left.red && color_center.red < color_right.red) {
            //Hit middle?
            telemetry.addLine("Hit center");
            telemetry.addData("red center", color_center.red);
            telemetry.addData("red left", color_left.red);
            telemetry.addData("red right", color_right.red);
            telemetry.update();
            sleep(15000);
        }

        //If CSright has more red than the other two, move right and then forward
        else if (color_right.red < color_center.red && color_right.red < color_left.red) {
            //Hit right?
            telemetry.addLine("Hit right");
            telemetry.addData("red center", color_center.red);
            telemetry.addData("red left", color_left.red);
            telemetry.addData("red right", color_right.red);
            telemetry.update();
            sleep(15000);
        }*/
    }

    //encoderDrive method to make the robot move with input in inches
    public void encoderDrive ( double speed, double frontleftinches, double frontrightinches,
                               double backleftinches, double backrightinches, double timeoutS){

        int frontleftTarget;
        int backleftTarget;
        int frontrightTarget;
        int backrightTarget;

        if (opModeIsActive()) {

            robot.frontleft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            robot.backleft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            robot.frontright.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            robot.backright.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

            robot.frontleft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            robot.backleft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            robot.frontright.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            robot.backright.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

            frontleftTarget = robot.frontleft.getCurrentPosition() + (int) (frontleftinches * robot.COUNTS_PER_INCH_REV);
            backleftTarget = robot.backleft.getCurrentPosition() + (int) (backleftinches * robot.COUNTS_PER_INCH_REV);
            frontrightTarget = robot.frontright.getCurrentPosition() + (int) (frontrightinches * robot.COUNTS_PER_INCH_REV);
            backrightTarget = robot.backright.getCurrentPosition() + (int) (backrightinches * robot.COUNTS_PER_INCH_REV);

            robot.frontleft.setTargetPosition(frontleftTarget);
            robot.backleft.setTargetPosition(backleftTarget);
            robot.frontright.setTargetPosition(frontrightTarget);
            robot.backright.setTargetPosition(backrightTarget);

            robot.frontleft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            robot.backleft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            robot.frontright.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            robot.backright.setMode(DcMotor.RunMode.RUN_TO_POSITION);

            runtime.reset();
            robot.frontleft.setPower(speed);
            robot.backleft.setPower(speed);
            robot.frontright.setPower(speed);
            robot.backright.setPower(speed);

            while (opModeIsActive() &&
                    (runtime.seconds() < timeoutS) &&
                    (robot.frontleft.isBusy() && robot.frontright.isBusy())) {
            }

            //Use the ZeroPower method to stop all motion
            robot.ZeroPower();

            robot.frontright.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            robot.backright.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            robot.frontleft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            robot.backleft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        }
    }
}