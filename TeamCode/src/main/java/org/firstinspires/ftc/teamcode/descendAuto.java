package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name = "Descend")
public class descendAuto extends LinearOpMode {

    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor leftDriveMotor = null;
    private DcMotor rightDriveMotor = null;
    private DcMotor armMotor = null;

    @Override
    public void runOpMode() throws InterruptedException {

        leftDriveMotor = hardwareMap.dcMotor.get("left drive motor");
        rightDriveMotor = hardwareMap.dcMotor.get("right drive motor");
        armMotor = hardwareMap.dcMotor.get("lift motor");

        leftDriveMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightDriveMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        armMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        leftDriveMotor.setDirection(DcMotor.Direction.FORWARD);
        rightDriveMotor.setDirection(DcMotor.Direction.REVERSE);
        leftDriveMotor.setDirection(DcMotor.Direction.FORWARD);

        waitForStart();
        runtime.reset();
        while (opModeIsActive() && runtime.seconds() <= 6)
        {
            if(runtime.seconds() <= 5) {
                armMotor.setPower(0.25);
                //leftDriveMotor.setPower(1.0);
                //rightDriveMotor.setPower(1.0);
            }
            else {
                armMotor.setPower(0.0);
            }
        }
        leftDriveMotor.setPower(0.0);
        rightDriveMotor.setPower(0.0);
        armMotor.setPower(0.0);
        idle();

    }
}