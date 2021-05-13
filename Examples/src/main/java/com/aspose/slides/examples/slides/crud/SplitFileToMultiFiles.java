package com.aspose.slides.examples.slides.crud;

import com.aspose.slides.*;
import com.aspose.slides.examples.RunExamples;


public class SplitFileToMultiFiles {
    public static void main(String[] args) {
        //ExStart:CloneAnotherPresentationAtSpecifiedPosition
        // The path to the documents directory.
        String dataDir = RunExamples.getDataDir_Slides_Presentations_CRUD();

        License license = new License();
        license.setLicense(dataDir + "Aspose.Slides.Java.lic");

        // Instantiate Presentation class for destination presentation (where slide is to be cloned)
        Presentation destPres = null;
        Presentation sourcePresentation = null;

        try {
            try {

                sourcePresentation = new Presentation(dataDir + "/SplitFileToMultiFiles/AccessSlides.pptx");

                for (int i = 0; i < sourcePresentation.getSlides().size(); i++) {
                    destPres = new Presentation();
                    ISlideCollection slideCollection = destPres.getSlides();
                    slideCollection.insertClone(0, sourcePresentation.getSlides().get_Item(i));
                    destPres.save(dataDir + "SplitFileToMultiFiles_out" + i + ".pptx", SaveFormat.Pptx);
                }

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (destPres != null) destPres.dispose();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sourcePresentation != null) sourcePresentation.dispose();
        }

        System.out.println("finish");
        //ExEnd:CloneAnotherPresentationAtSpecifiedPosition
    }
}
